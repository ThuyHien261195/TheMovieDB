package com.taidang.themoviedb.presentation.di.module.common

import com.taidang.themoviedb.domain.*
import com.taidang.themoviedb.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class UsecaseModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providesGetConfigUsecase(schedulerFactory: SchedulerFactory, configurationRepository: ConfigurationRepository): GetConfigUsecase {
            return GetConfigUsecase(schedulerFactory, configurationRepository)
        }

        @Provides
        @JvmStatic
        fun providesGetMoviesUsecase(schedulerFactory: SchedulerFactory, movieRepository: MovieRepository): GetMoviesUsecase {
            return GetMoviesUsecase(schedulerFactory, movieRepository)
        }

        @Provides
        @JvmStatic
        fun providesGetMovieDetailsUsecase(schedulerFactory: SchedulerFactory, movieRepository: MovieRepository): GetMovieDetailsUsecase {
            return GetMovieDetailsUsecase(schedulerFactory, movieRepository)
        }

        @Provides
        @JvmStatic
        fun provideGetTvShowsUsecase(schedulerFactory: SchedulerFactory, tvShowRepository: TvShowRepository) : GetTvShowsUsecase {
            return GetTvShowsUsecase(schedulerFactory, tvShowRepository)
        }

        @Provides
        @JvmStatic
        fun provideGetTvShowDetailsUsecase(schedulerFactory: SchedulerFactory, tvShowRepository: TvShowRepository) : GetTvShowDetailsUsecase {
            return GetTvShowDetailsUsecase(schedulerFactory, tvShowRepository)
        }

        @Provides
        @JvmStatic
        fun provideGetTvSeasonDetailsUsecase(schedulerFactory: SchedulerFactory, tvSeasonRepository: TvSeasonRepository) : GetTvSeasonDetailsUsecase {
            return GetTvSeasonDetailsUsecase(schedulerFactory, tvSeasonRepository)
        }

        @Provides
        @JvmStatic
        fun provideGetTvEpisodeDetailsUsecase(scheduleFactory: SchedulerFactory, tvEpisodeRepository: TvEpisodeRepository): GetTvEpisodeDetailsUsecase {
            return GetTvEpisodeDetailsUsecase(scheduleFactory, tvEpisodeRepository)
        }
    }
}