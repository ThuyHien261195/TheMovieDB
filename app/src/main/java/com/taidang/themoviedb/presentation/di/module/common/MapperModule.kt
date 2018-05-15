package com.taidang.themoviedb.presentation.di.module.common

import com.taidang.themoviedb.repository.mapper.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class MapperModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providesImagesMapper() = ImagesConfigMapper()

        @Provides
        @JvmStatic
        fun providesApiConfigurationMapper(imagesConfigMapper: ImagesConfigMapper) = ApiConfigurationMapper(imagesConfigMapper)

        @Provides
        @JvmStatic
        fun providesCountryMapper() = CountryMapper()

        @Provides
        @JvmStatic
        fun providesCastMapper() = CastMapper()

        @Provides
        @JvmStatic
        fun providesClipMapper() = ClipMapper()

        @Provides
        @JvmStatic
        fun providesCrewMapper() = CrewMapper()

        @Provides
        @JvmStatic
        fun providesMovieDetailsMapper(castMapper: CastMapper, clipMapper: ClipMapper) = MovieDetailsMapper(castMapper, clipMapper)

        @Provides
        @JvmStatic
        fun providesMovieMapper(detailsMapper: MovieDetailsMapper) = MovieMapper(detailsMapper)

        @Provides
        @JvmStatic
        fun providesMoviesInfoMapper(movieMapper: MovieMapper) = MoviesInfoMapper(movieMapper)

        @Provides
        @JvmStatic
        fun providesTvShowDetailsMapper(castMapper: CastMapper, clipMapper: ClipMapper, tvSeasonMapper: TvSeasonMapper)
                = TvShowDetailsMapper(castMapper, clipMapper, tvSeasonMapper)

        @Provides
        @JvmStatic
        fun providesTvShowMapper(detailsMapper: TvShowDetailsMapper) = TvShowMapper(detailsMapper)

        @Provides
        @JvmStatic
        fun providesTvShowInfoMapper(tvShowMapper: TvShowMapper) = TvShowsInfoMapper(tvShowMapper)

        @Provides
        @JvmStatic
        fun providesTvEpisodeDetailsMapper(castMapper: CastMapper, crewMapper: CrewMapper, clipMapper: ClipMapper)
                = TvEpisodeDetailsMapper(castMapper, crewMapper, clipMapper)

        @Provides
        @JvmStatic
        fun providesTvEpisodeMapper(tvEpisodeDetailsMapper: TvEpisodeDetailsMapper) = TvEpisodeMapper(tvEpisodeDetailsMapper)

        @Provides
        @JvmStatic
        fun providesTvSeasonDetailsMapper(castMapper: CastMapper, clipMapper: ClipMapper, tvEpisodeMapper: TvEpisodeMapper)
                = TvSeasonDetailsMapper(castMapper, clipMapper, tvEpisodeMapper)

        @Provides
        @JvmStatic
        fun providesTvSeasonMapper(tvSeasonDetailsMapper: TvSeasonDetailsMapper) = TvSeasonMapper(tvSeasonDetailsMapper)
    }
}