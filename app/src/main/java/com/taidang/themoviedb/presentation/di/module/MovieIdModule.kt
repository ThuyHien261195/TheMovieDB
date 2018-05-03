package com.taidang.themoviedb.presentation.di.module

import com.taidang.themoviedb.presentation.activity.MovieDetailsActivity
import dagger.Module
import dagger.Provides

/**
 * Created by thuyhien on 5/3/18.
 */
@Module
abstract class MovieIdModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideMovieId(movieDetailsActivity: MovieDetailsActivity) : Int {
            return movieDetailsActivity.getMovieId()
        }
    }
}
