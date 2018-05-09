package com.taidang.themoviedb.presentation.di.module

import com.taidang.themoviedb.presentation.di.ChildFragmentScoped
import com.taidang.themoviedb.presentation.fragment.NowPlayingMoviesFragment
import com.taidang.themoviedb.presentation.fragment.UpcomingMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by thuyhien on 5/3/18.
 */
@Module
abstract class MovieListingModule {
    @ChildFragmentScoped
    @ContributesAndroidInjector(modules = [NowPlayingMoviesModule::class])
    abstract fun bindsNowPlayingMoviesFragment() : NowPlayingMoviesFragment

    @ChildFragmentScoped
    @ContributesAndroidInjector(modules = [UpcomingMoviesModule::class])
    abstract fun bindsUpcomingMoviesFragment() : UpcomingMoviesFragment
}