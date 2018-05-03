package com.taidang.themoviedb.presentation.di.module

import com.taidang.themoviedb.domain.usecase.GetMovieDetailsUsecase
import com.taidang.themoviedb.presentation.activity.MovieDetailsActivity
import com.taidang.themoviedb.presentation.contract.MovieDetailsContract
import com.taidang.themoviedb.presentation.di.DependencyName
import com.taidang.themoviedb.presentation.presenter.MovieDetailsPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class MovieDetailsModule() {
    @Binds
    abstract fun providesMovieDetailsPresenter(movieDetailsPresenter : MovieDetailsPresenter ): MovieDetailsContract.Presenter
}