package com.taidang.themoviedb.di.module

import com.taidang.themoviedb.domain.ConfigurationRepository
import com.taidang.themoviedb.domain.MovieRepository
import com.taidang.themoviedb.domain.TvShowRepository
import com.taidang.themoviedb.presentation.di.ApplicationScoped
import com.taidang.themoviedb.repository.ConfigurationRemoteDataStore
import com.taidang.themoviedb.repository.MovieRemoteDataStore
import com.taidang.themoviedb.repository.TvShowRemoteDataStore
import com.taidang.themoviedb.repository.http.ConfigurationHttpClient
import com.taidang.themoviedb.repository.http.MovieHttpClient
import com.taidang.themoviedb.repository.http.TvShowHttpClient
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
    }
}