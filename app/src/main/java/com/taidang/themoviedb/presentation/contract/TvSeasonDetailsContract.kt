package com.taidang.themoviedb.presentation.contract

import com.taidang.themoviedb.domain.model.TvEpisode
import com.taidang.themoviedb.domain.model.TvSeason
import com.taidang.themoviedb.presentation.contract.base.IBasePresenter
import com.taidang.themoviedb.presentation.contract.base.IBaseView

/**
 * Created by thuyhien on 5/14/18.
 */
interface TvSeasonDetailsContract {
    interface View : IBaseView<Presenter> {
        fun showDetails(tvSeason: TvSeason)
        fun gotoTvEpisode(tvEpisode: TvEpisode)
    }

    interface Presenter: IBasePresenter<View> {
        fun chooseTvEpisode(tvEpisode: TvEpisode)
    }
}