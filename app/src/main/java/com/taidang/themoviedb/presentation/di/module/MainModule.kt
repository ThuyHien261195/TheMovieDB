package com.taidang.themoviedb.presentation.di.module

import com.taidang.themoviedb.presentation.di.FragmentScoped
import com.taidang.themoviedb.presentation.fragment.MovieFragment
import com.taidang.themoviedb.presentation.fragment.TvShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {
    @FragmentScoped
    @ContributesAndroidInjector(modules = [MovieListingModule::class])
    abstract fun bindsMovieFragment(): MovieFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = [TvShowListingModule::class])
    abstract fun bindsTvShowFragment(): TvShowFragment
}