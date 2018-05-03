package com.taidang.themoviedb.presentation.di.module

import com.taidang.themoviedb.domain.usecase.GetMoviesUsecase
import com.taidang.themoviedb.presentation.contract.UpcomingMoviesContract
import com.taidang.themoviedb.presentation.manager.AppConfigManager
import com.taidang.themoviedb.presentation.presenter.UpcomingMoviesPresenter
import dagger.Binds
import dagger.Module

/**
 * Created by thuyhien on 4/27/18.
 */
@Module
abstract class UpcomingMoviesModule {
    @Binds
    abstract fun providesUpcomingMoviesPresenter(upcomingMoviesPresenter: UpcomingMoviesPresenter): UpcomingMoviesContract.Presenter
}