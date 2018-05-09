package com.taidang.themoviedb.presentation.contract

import com.taidang.themoviedb.domain.model.TvShow
import com.taidang.themoviedb.presentation.contract.base.IBasePresenter
import com.taidang.themoviedb.presentation.contract.base.IBaseView

/**
 * Created by thuyhien on 5/7/18.
 */
interface PopularTvShowsContract {
    interface View : IBaseView<Presenter> {
        fun displayTvShows(tvShows: List<TvShow>)
        fun gotoDetailTvShow(tvShow: TvShow)
    }

    interface Presenter : IBasePresenter<View> {
        fun chooseTvShow(tvShow: TvShow)
    }
}