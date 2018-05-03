package com.taidang.themoviedb.presentation.di.module

import com.taidang.themoviedb.presentation.di.FragmentScoped
import com.taidang.themoviedb.presentation.fragment.NowPlayingMoviesFragment
import com.taidang.themoviedb.presentation.fragment.UpcomingMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MoviesListingModule {
    @FragmentScoped
    @ContributesAndroidInjector(modules = [NowPlayingMoviesModule::class])
    abstract fun bindsNowPlayingMoviesFragment() : NowPlayingMoviesFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = [UpcomingMoviesModule::class])
    abstract fun bindsUpcomingMoviesFragment() : UpcomingMoviesFragment
}