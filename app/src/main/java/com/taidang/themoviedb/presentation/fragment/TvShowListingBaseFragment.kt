package com.taidang.themoviedb.presentation.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.taidang.themoviedb.R
import com.taidang.themoviedb.domain.model.ImagesConfig
import com.taidang.themoviedb.domain.model.TvShow
import com.taidang.themoviedb.extension.gone
import com.taidang.themoviedb.extension.visible
import com.taidang.themoviedb.presentation.adapter.decoration.LinearItemDecoration
import com.taidang.themoviedb.presentation.adapter.TvShowsListingAdapter
import com.taidang.themoviedb.presentation.contract.base.IBaseView
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_movies_listing.*
import org.jetbrains.anko.support.v4.dip

/**
 * Created by thuyhien on 5/8/18.
 */
abstract class TvShowListingBaseFragment<PRESENTER> : DaggerFragment(), IBaseView<PRESENTER> {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies_listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vListingView.layoutManager = LinearLayoutManager(this.context)
        val itemDecoration = LinearItemDecoration(dip(4), false, 0)
        vListingView.addItemDecoration(itemDecoration)
    }

    override fun displayLoading() {
        hideAllViewExcept(vLoading)
    }

    override fun hideLoading() {
        hideAllViewExcept()
    }

    override fun displayError(throwable: Throwable) {
        vErrorMessage.text = throwable.message
        hideAllViewExcept(vErrorMessage)
    }

    private fun hideAllViewExcept(tobeDisplay: View? = null) {
        vLoading.gone()
        vListingView.gone()
        vErrorMessage.gone()
        tobeDisplay?.visible()
    }

    protected fun displayTvShows(tvShows: List<TvShow>, imagesConfig: ImagesConfig, onItemClick: (TvShow) -> Unit) {
        vListingView.adapter = TvShowsListingAdapter(tvShows, imagesConfig, onItemClick)
        hideAllViewExcept(vListingView)
    }

    protected fun gotoTvShowDetails(tvShow: TvShow) {

    }
}