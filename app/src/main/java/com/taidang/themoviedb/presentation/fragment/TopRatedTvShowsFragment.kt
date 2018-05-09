package com.taidang.themoviedb.presentation.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.taidang.themoviedb.domain.model.TvShow
import com.taidang.themoviedb.presentation.contract.TopRatedTvShowsContract
import com.taidang.themoviedb.presentation.manager.AppConfigManager
import javax.inject.Inject

/**
 * Created by thuyhien on 5/7/18.
 */
class TopRatedTvShowsFragment() : TvShowListingBaseFragment<TopRatedTvShowsContract.Presenter>(),
    TopRatedTvShowsContract.View {
    @Inject
    lateinit var mAppConfigManager: AppConfigManager

    @Inject
    override lateinit var mPresenter: TopRatedTvShowsContract.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(mPresenter) {
            attachView(this@TopRatedTvShowsFragment)
            start()
        }
    }

    override fun onDestroy() {
        mPresenter.destroy()
        super.onDestroy()
    }

    override fun displayTvShows(tvShows: List<TvShow>) {
        super.displayTvShows(tvShows, mAppConfigManager.getImagesConfig()) {
            clickedItem -> mPresenter.chooseTvShow(clickedItem)
        }
    }

    override fun gotoDetailTvShow(tvShow: TvShow) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}