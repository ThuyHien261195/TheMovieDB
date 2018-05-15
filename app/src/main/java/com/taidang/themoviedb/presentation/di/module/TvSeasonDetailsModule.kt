package com.taidang.themoviedb.presentation.di.module

import com.taidang.themoviedb.presentation.contract.TvSeasonDetailsContract
import com.taidang.themoviedb.presentation.presenter.TvSeasonDetailsPresenter
import dagger.Binds
import dagger.Module

/**
 * Created by thuyhien on 5/14/18.
 */
@Module
abstract class TvSeasonDetailsModule {
    @Binds
    abstract fun provideTvSeasonDetailsPresenter(tvSeasonDetailsPresenter: TvSeasonDetailsPresenter) : TvSeasonDetailsContract.Presenter
}