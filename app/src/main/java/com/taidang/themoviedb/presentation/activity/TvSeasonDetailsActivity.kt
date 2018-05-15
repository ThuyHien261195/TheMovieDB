package com.taidang.themoviedb.presentation.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.taidang.themoviedb.R
import com.taidang.themoviedb.domain.model.*
import com.taidang.themoviedb.extension.configHorizontalListView
import com.taidang.themoviedb.extension.gone
import com.taidang.themoviedb.extension.visible
import com.taidang.themoviedb.presentation.activity.TvShowDetailsActivity.Companion.EXTRA_TV_SHOW_ID
import com.taidang.themoviedb.presentation.adapter.CastAdapter
import com.taidang.themoviedb.presentation.adapter.TvEpisodeAdapter
import com.taidang.themoviedb.presentation.contract.TvSeasonDetailsContract
import kotlinx.android.synthetic.main.activity_tv_season_details.*
import kotlinx.android.synthetic.main.include_movie_details_cast_section.*
import kotlinx.android.synthetic.main.include_tv_season_details_episode_section.*
import kotlinx.android.synthetic.main.include_tv_season_details_overview_section.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class TvSeasonDetailsActivity : BaseActivity(), TvSeasonDetailsContract.View {
    companion object {
        const val EXTRA_TV_SEASON_ID = "extra-tv-season-id"
    }

    @Inject
    lateinit var imageConfig: ImagesConfig

    @Inject
    override lateinit var mPresenter: TvSeasonDetailsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_season_details)


        with(mPresenter) {
            attachView(this@TvSeasonDetailsActivity)
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

    override fun showDetails(tvSeason: TvSeason) {
        renderOverview(tvSeason)
        renderCasts(tvSeason.seasonDetails?.casts ?: emptyList())
        renderEpisode(tvSeason.seasonDetails?.episodes ?: emptyList())
        scTvSeasonDetailsListing.visible()
    }

    override fun gotoTvEpisode(tvEpisode: TvEpisode) {
        Toast.makeText(this, "TvEpisode ${tvEpisode.name}", Toast.LENGTH_LONG).show()
    }

    private fun renderOverview(tvSeason: TvSeason) {

        val firstAirDate = SimpleDateFormat("yyyy", Locale.US).format(tvSeason.airDate)
        tvPrimaryInfo.text =  "${tvSeason.seasonDetails?.getTvEpisodeNumber()} | $firstAirDate"

        tvSeason.seasonDetails?.run {
            tvName.text = name
            tvDescription.text = overview
        }

        Glide.with(this)
                .load(imageConfig.buildPosterUrl(tvSeason.posterPath, ImageSize.MEDIUM))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivPoster)
    }

    private fun renderCasts(casts: List<Cast>) {
        val filterList = casts.filter {
            it.profile_path != null && it.profile_path.isNotEmpty()
        }

        vCastListing.configHorizontalListView(this)
        vCastListing.adapter = CastAdapter(filterList, imageConfig)
    }

    private fun renderEpisode(tvEpisodes: List<TvEpisode>) {
        val filterList = tvEpisodes.filter {
            it.stillPath != null && it.stillPath.isNotEmpty()
        }

        rvEpisodeListing.configHorizontalListView(this)
        rvEpisodeListing.adapter = TvEpisodeAdapter(filterList, imageConfig, {
            tvEpisode -> mPresenter.chooseTvEpisode(tvEpisode)
        })
    }

    fun getTvShowId() = intent.getIntExtra(EXTRA_TV_SHOW_ID, -1)

    fun getTvSeasonId() = intent.getIntExtra(EXTRA_TV_SEASON_ID, -1)
}
