package com.taidang.themoviedb.presentation.di.module

import com.taidang.themoviedb.domain.usecase.GetMoviesUsecase
import com.taidang.themoviedb.presentation.contract.NowPlayingMoviesContract
import com.taidang.themoviedb.presentation.di.FragmentScoped
import com.taidang.themoviedb.presentation.manager.AppConfigManager
import com.taidang.themoviedb.presentation.presenter.NowPlayingMoviesPresenter
import dagger.Binds
import dagger.Module

/**
 * Created by thuyhien on 4/27/18.
 */
@Module
abstract class NowPlayingMoviesModule {
    @Binds
    abstract fun providesNowPlayingMoviesPresenter(nowPlayingMoviesPresenter: NowPlayingMoviesPresenter): NowPlayingMoviesContract.Presenter
}