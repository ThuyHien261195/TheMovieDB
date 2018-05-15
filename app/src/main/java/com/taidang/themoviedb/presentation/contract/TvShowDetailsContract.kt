package com.taidang.themoviedb.presentation.contract

import com.taidang.themoviedb.domain.model.TvSeason
import com.taidang.themoviedb.domain.model.TvShow
import com.taidang.themoviedb.presentation.contract.base.IBasePresenter
import com.taidang.themoviedb.presentation.contract.base.IBaseView

/**
 * Created by thuyhien on 5/10/18.
 */
interface TvShowDetailsContract {
    interface View : IBaseView<Presenter> {
        fun showDetails(tvShow: TvShow)
        fun goToTvShow(tvSeason: TvSeason)
    }

    interface Presenter : IBasePresenter<View> {
        fun chooseSeason(tvSeason: TvSeason)
    }
}