package com.taidang.themoviedb.presentation.di.module

import com.taidang.themoviedb.presentation.contract.PopularTvShowsContract
import com.taidang.themoviedb.presentation.presenter.PopularTvShowPresenter
import dagger.Binds
import dagger.Module

/**
 * Created by thuyhien on 5/8/18.
 */
@Module
abstract class PopularTvShowsModule {
    @Binds
    abstract fun providePopularTvShowsPresenter(popularTvShowPresenter: PopularTvShowPresenter) : PopularTvShowsContract.Presenter
}