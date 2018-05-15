package com.taidang.themoviedb.presentation.activity

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.taidang.themoviedb.R
import com.taidang.themoviedb.domain.model.*
import com.taidang.themoviedb.extension.configHorizontalListView
import com.taidang.themoviedb.extension.gone
import com.taidang.themoviedb.extension.visible
import com.taidang.themoviedb.presentation.adapter.CastAdapter
import com.taidang.themoviedb.presentation.adapter.TvSeasonAdapter
import com.taidang.themoviedb.presentation.contract.TvShowDetailsContract
import kotlinx.android.synthetic.main.activity_tv_show_details.*
import kotlinx.android.synthetic.main.include_movie_details_cast_section.*
import kotlinx.android.synthetic.main.include_movie_details_description_section.*
import kotlinx.android.synthetic.main.include_movie_details_overview_section.*
import kotlinx.android.synthetic.main.include_movie_details_product_info.*
import kotlinx.android.synthetic.main.include_tv_show_details_season_section.*
import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * Created by thuyhien on 5/10/18.
 */
class TvShowDetailsActivity : BaseActivity(), TvShowDetailsContract.View {
    companion object {
        const val EXTRA_TV_SHOW_ID = "extra-tv-show-id"
    }
    
    @Inject
    lateinit var imagesConfig: ImagesConfig

    @Inject
    override lateinit var mPresenter: TvShowDetailsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show_details)

        with(mPresenter) {
            attachView(this@TvShowDetailsActivity)
            start()
        }
    }

    override fun displayLoading() {
        vLoading.visible()
    }

    override fun hideLoading() {
        vLoading.gone()
    }

    override fun displayError(throwable: Throwable) {
        showErrorMessage(throwable.message)
    }

    override fun showDetails(tvShow: TvShow) {
        renderOverview(tvShow)
        renderCasts(tvShow.details?.casts ?: emptyList())
        renderProductInfo(tvShow)
        renderSection(tvShow.details?.seasons ?: emptyList())
        scTvShowDetailsListing.visible()
    }

    override fun goToTvShow(tvSeason: TvSeason) {
         startActivity<TvSeasonDetailsActivity>(TvShowDetailsActivity.EXTRA_TV_SHOW_ID to getTvShowId(),
                 TvSeasonDetailsActivity.EXTRA_TV_SEASON_ID to tvSeason.seasonNumber)
    }

    override fun onDestroy() {
        mPresenter.destroy()
        super.onDestroy()
    }

    private fun renderOverview(tvShow: TvShow) {
        Glide.with(this)
                .load(imagesConfig.buildBackdropUrl(tvShow.backdropPath, ImageSize.MEDIUM))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivBackdrop)

        Glide.with(this)
                .load(imagesConfig.buildPosterUrl(tvShow.posterPath, ImageSize.SMALL))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(vPoster)

        vName.text = tvShow.title

        tvShow.details?.run {
            vTagline.text = tagline
            val firstAirDate = SimpleDateFormat("yyyy", Locale.US).format(tvShow.firstAirDate)
            vPrimaryInfo.text = "${getSeasonNumber()} | $firstAirDate | ${genres.joinToString()}"
            vDescription.text = description
        }

        tvShow.details?.contentRating?.let {
            tvContentRating.visible()
            tvContentRating.text = it[0]
        } ?: tvContentRating.gone()
    }

    private fun renderCasts(casts: List<Cast>) {
        val filterList = casts.filter {
            it.profile_path != null && it.profile_path.isNotEmpty()
        }

        vCastListing.configHorizontalListView(this)
        vCastListing.adapter = CastAdapter(filterList, imagesConfig)
    }

    private fun renderProductInfo(tvShow: TvShow) {
        vInfoReleaseDate.text = SimpleDateFormat("MMM dd yyyy", Locale.US).format(tvShow.firstAirDate)
        tvShow.details?.run {
            vInfoCountry.text = companies.map { it.name }.joinToString()
            vInfoKeyword.text = keywords.joinToString()
            vInfoCompanies.gone()
            vLabelCompanies.gone()
        }
    }

    private fun renderSection(seasons: List<TvSeason>) {
        val filterList = seasons.filter {
            it.posterPath != null && it.posterPath.isNotEmpty()
        }

        rvSeasonListing.configHorizontalListView(this)
        rvSeasonListing.adapter = TvSeasonAdapter(filterList, imagesConfig, {
            clickedItem -> mPresenter.chooseSeason(clickedItem)
        })
    }

    fun getTvShowId() = intent.getIntExtra(EXTRA_TV_SHOW_ID, -1)
}