package com.taidang.themoviedb.presentation.di.module

import com.taidang.themoviedb.presentation.di.ChildFragmentScoped
import com.taidang.themoviedb.presentation.fragment.PopularTvShowsFragment
import com.taidang.themoviedb.presentation.fragment.TopRatedTvShowsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by thuyhien on 5/8/18.
 */
@Module
abstract class TvShowListingModule {
    @ChildFragmentScoped
    @ContributesAndroidInjector(modules = [PopularTvShowsModule::class])
    abstract fun bindsPopularTvShowsFragment(): PopularTvShowsFragment

    @ChildFragmentScoped
    @ContributesAndroidInjector(modules = [TopRatedTvShowsModule::class])
    abstract fun bindsTopRatedShowsFragment(): TopRatedTvShowsFragment
}