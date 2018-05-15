package com.taidang.themoviedb.presentation.di.module

import com.taidang.themoviedb.presentation.activity.TvSeasonDetailsActivity
import com.taidang.themoviedb.presentation.di.DependencyName
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by thuyhien on 5/14/18.
 */
@Module
class TvSeasonIdModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        @Named(DependencyName.DI_TV_SHOW_ID)
        fun provideTvShowId(tvSeasonDetailsActivity: TvSeasonDetailsActivity): Int = tvSeasonDetailsActivity.getTvShowId()

        @Provides
        @JvmStatic
        @Named(DependencyName.DI_TV_SEASON_ID)
        fun provideTvSeasonId(tvSeasonDetailsActivity: TvSeasonDetailsActivity): Int = tvSeasonDetailsActivity.getTvSeasonId()
    }
}