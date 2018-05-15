package com.taidang.themoviedb.presentation.di.module

import com.taidang.themoviedb.presentation.activity.TvShowDetailsActivity
import dagger.Module
import dagger.Provides

/**
 * Created by thuyhien on 5/10/18.
 */
@Module
abstract class TvShowIdModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideTvShowId(tvShowDetailsActivity: TvShowDetailsActivity) : Int = tvShowDetailsActivity.getTvShowId()
    }
}