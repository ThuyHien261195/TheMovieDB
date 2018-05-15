package com.taidang.themoviedb.repository.mapper

import com.google.gson.JsonElement
import com.taidang.themoviedb.domain.model.GuestStar
import com.taidang.themoviedb.domain.model.TvEpisode
import com.taidang.themoviedb.domain.model.TvEpisodeDetails
import com.taidang.themoviedb.repository.response.TvEpisodeEntity

/**
 * Created by thuyhien on 5/11/18.
 */
class TvEpisodeMapper(private val tvEpisodeDetailsMapper: TvEpisodeDetailsMapper) : IMapper<TvEpisodeEntity, TvEpisode> {
    override fun transform(entity: TvEpisodeEntity): TvEpisode {
        val details = transformDetails(entity)
        return TvEpisode(
                entity.air_date?.time ?: 0,
                entity.episode_number,
                entity.name,
                entity.overview,
                entity.vote_average,
                entity.still_path,
                details)
    }

    private fun transformDetails(entity: TvEpisodeEntity) : TvEpisodeDetails? {
        return if (hasDetails(entity)) tvEpisodeDetailsMapper.transform(entity)
        else null
    }

    private fun hasDetails(entity: TvEpisodeEntity) = entity.videos != null
}