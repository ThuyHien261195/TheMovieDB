package com.taidang.themoviedb.presentation.di.module

import com.taidang.themoviedb.presentation.contract.TopRatedTvShowsContract
import com.taidang.themoviedb.presentation.presenter.TopRatedTvShowPresenter
import dagger.Binds
import dagger.Module

/**
 * Created by thuyhien on 5/8/18.
 */
@Module
abstract class TopRatedTvShowsModule {
    @Binds
    abstract fun provideTopRatedTvShowsPresenter(topRatedTvShowPresenter: TopRatedTvShowPresenter) : TopRatedTvShowsContract.Presenter
}