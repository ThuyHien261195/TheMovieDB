package com.taidang.themoviedb.repository.mapper

import com.taidang.themoviedb.domain.model.TvSeason
import com.taidang.themoviedb.domain.model.TvSeasonDetails
import com.taidang.themoviedb.repository.response.TvSeasonEntity

/**
 * Created by thuyhien on 5/11/18.
 */
class TvSeasonMapper(private val tvSeasonDetailsMapper: TvSeasonDetailsMapper) : IMapper<TvSeasonEntity, TvSeason> {
    override fun transform(entity: TvSeasonEntity): TvSeason {
        val details = transformDetails(entity)
        return TvSeason(entity.id,
                entity.air_date?.time ?: 0,
                entity.episode_count,
                entity.poster_path,
                entity.season_number,
                details
        )
    }

    private fun transformDetails(entity: TvSeasonEntity) : TvSeasonDetails? {
        return if(hasDetails(entity)) tvSeasonDetailsMapper.transform(entity)
        else null
    }

    private fun hasDetails(entity: TvSeasonEntity) = entity.videos != null
}