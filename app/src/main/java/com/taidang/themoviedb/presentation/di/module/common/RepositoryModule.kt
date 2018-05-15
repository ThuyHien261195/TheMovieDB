package com.taidang.themoviedb.di.module

import com.taidang.themoviedb.domain.*
import com.taidang.themoviedb.presentation.di.ApplicationScoped
import com.taidang.themoviedb.repository.*
import com.taidang.themoviedb.repository.http.*
import com.taidang.themoviedb.repository.mapper.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        @ApplicationScoped
        fun providesConfigurationRepo(configurationHttpClient: ConfigurationHttpClient,
                                      apiConfigurationMapper: ApiConfigurationMapper,
                                      countryMapper: CountryMapper): ConfigurationRepository {
            return ConfigurationRemoteDataStore(configurationHttpClient, apiConfigurationMapper, countryMapper)
        }

        @Provides
        @JvmStatic
        @ApplicationScoped
        fun providesMovieRepo(movieHttpClient: MovieHttpClient, moviesInfoMapper: MoviesInfoMapper, movieMapper: MovieMapper): MovieRepository {
            return MovieRemoteDataStore(movieHttpClient, moviesInfoMapper, movieMapper)
        }

        @Provides
        @JvmStatic
        @ApplicationScoped
        fun provideTvShowRepo(tvShowHttpClient: TvShowHttpClient, tvShowsInfoMapper: TvShowsInfoMapper, tvShowMapper: TvShowMapper) : TvShowRepository {
            return TvShowRemoteDataStore(tvShowHttpClient, tvShowsInfoMapper, tvShowMapper)
        }

        @Provides
        @JvmStatic
        @ApplicationScoped
        fun provideTvSeasonRepo(tvSeasonHttpClient: TvSeasonHttpClient, tvSeasonMapper: TvSeasonMapper) : TvSeasonRepository{
            return TvSeasonRemoteDataStore(tvSeasonHttpClient, tvSeasonMapper)
        }

        @Provides
        @JvmStatic
        @ApplicationScoped
        fun provideTvEpisodeRepo(tvEpisodeHttpClient: TvEpisodeHttpClient,
                                 tvEpisodeMapper: TvEpisodeMapper) : TvEpisodeRepository{
            return TvEpisodeRemoteDataStore(tvEpisodeHttpClient, tvEpisodeMapper)
        }
    }
}