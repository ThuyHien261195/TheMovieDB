package com.taidang.themoviedb.presentation.di.module.common

import com.taidang.themoviedb.presentation.activity.*
import com.taidang.themoviedb.presentation.di.ActivityScoped
import com.taidang.themoviedb.presentation.di.module.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by thuyhien on 4/27/18.
 */
@Module
abstract class ActivityBuilderModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun bindsSplashActivity(): SplashActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainModule::class, MovieListingModule::class, TvShowListingModule::class])
    abstract fun bindsMainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MovieDetailsModule::class, MovieIdModule::class])
    abstract fun bindsMovieDetailsActivity(): MovieDetailsActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [TvShowDetailsModule::class, TvShowIdModule::class])
    abstract fun bindsTvShowDetailsActivity(): TvShowDetailsActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [TvSeasonDetailsModule::class, TvSeasonIdModule::class])
    abstract fun bindsTvSeasonDetailsActivity(): TvSeasonDetailsActivity
}