package com.taidang.themoviedb.repository.mapper

import com.taidang.themoviedb.domain.model.TvSeason
import com.taidang.themoviedb.domain.model.TvSeasonDetails
import com.taidang.themoviedb.domain.model.TvShowDetails
import com.taidang.themoviedb.repository.response.TvSeasonEntity

/**
 * Created by thuyhien on 5/11/18.
 */
class TvSeasonDetailsMapper(private val castMapper: CastMapper,
                            private val clipMapper: ClipMapper,
                            private val tvEpisodeMapper: TvEpisodeMapper)
    : IMapper<TvSeasonEntity, TvSeasonDetails> {
    override fun transform(entity: TvSeasonEntity): TvSeasonDetails {
        val casts = castMapper.transform(entity.credits.cast)
        val clips = clipMapper.transform(entity.videos?.results!!)
        val tvEpisodes = tvEpisodeMapper.transform(entity.episodes)
        return TvSeasonDetails(
                entity.name,
                entity.overview,
                casts,
                clips,
                tvEpisodes)
    }
}