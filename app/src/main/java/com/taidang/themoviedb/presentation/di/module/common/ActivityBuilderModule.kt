package com.taidang.themoviedb.presentation.di.module.common

import com.taidang.themoviedb.presentation.activity.MainActivity
import com.taidang.themoviedb.presentation.activity.MovieDetailsActivity
import com.taidang.themoviedb.presentation.activity.SplashActivity
import com.taidang.themoviedb.presentation.di.ActivityScoped
import com.taidang.themoviedb.presentation.di.DependencyName
import com.taidang.themoviedb.presentation.di.module.MovieDetailsModule
import com.taidang.themoviedb.presentation.di.module.MovieIdModule
import com.taidang.themoviedb.presentation.di.module.MoviesListingModule
import com.taidang.themoviedb.presentation.di.module.SplashModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Named

/**
 * Created by thuyhien on 4/27/18.
 */
@Module
abstract class ActivityBuilderModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun bindsSplashActivity(): SplashActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MoviesListingModule::class])
    abstract fun bindsMainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MovieDetailsModule::class, MovieIdModule::class])
    abstract fun bindsMovieDetailsActivity(): MovieDetailsActivity
}