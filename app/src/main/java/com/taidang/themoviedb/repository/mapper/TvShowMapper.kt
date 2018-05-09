package com.taidang.themoviedb.repository.mapper

import com.taidang.themoviedb.domain.model.TvShow
import com.taidang.themoviedb.domain.model.TvShowDetails
import com.taidang.themoviedb.repository.response.TvShowEntity

/**
 * Created by thuyhien on 5/7/18.
 */
class TvShowMapper(private val tvShowDetailsMapper: TvShowDetailsMapper)
    : IMapper<TvShowEntity, TvShow> {
    override fun transform(entity: TvShowEntity): TvShow {
        val details = transformDetails(entity)
        return TvShow(entity.id,
                entity.name,
                entity.first_air_date.time,
                entity.poster_path ?: "",
                entity.backdrop_path ?: "",
                entity.vote_average,
                details)
    }

    private fun transformDetails(entity: TvShowEntity): TvShowDetails? {
        return if (hasDetails(entity)) tvShowDetailsMapper.transform(entity)
        else null
    }

    private fun hasDetails(entity: TvShowEntity) = entity.genres != null
}