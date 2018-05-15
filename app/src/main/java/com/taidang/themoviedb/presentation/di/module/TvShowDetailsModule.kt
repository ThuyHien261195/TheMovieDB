package com.taidang.themoviedb.presentation.di.module

import com.taidang.themoviedb.presentation.contract.TvShowDetailsContract
import com.taidang.themoviedb.presentation.presenter.TvShowDetailsPresenter
import dagger.Binds
import dagger.Module

/**
 * Created by thuyhien on 5/10/18.
 */
@Module
abstract class TvShowDetailsModule {
    @Binds
    abstract fun provideTvShowDetailsPresenter(tvShowDetailsPresenter: TvShowDetailsPresenter) : TvShowDetailsContract.Presenter
}