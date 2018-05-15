package com.taidang.themoviedb.repository

import com.taidang.themoviedb.domain.TvEpisodeRepository
import com.taidang.themoviedb.domain.model.TvEpisode
import com.taidang.themoviedb.repository.http.TvEpisodeHttpClient
import com.taidang.themoviedb.repository.mapper.TvEpisodeMapper
import io.reactivex.Single

/**
 * Created by thuyhien on 5/14/18.
 */
class TvEpisodeRemoteDataStore(private val tvEpisodeHttpClient: TvEpisodeHttpClient,
                               private val tvEpisodeMapper: TvEpisodeMapper)
    : TvEpisodeRepository {
    override fun getTvEpisodeDetails(tvShowId: Int, tvSeasonNum: Int, tvEpisodeNum: Int): Single<TvEpisode> {
        return tvEpisodeHttpClient.getTvEpisodeDetails(tvShowId,
                tvSeasonNum,
                tvEpisodeNum,
                "en-US",
                "credits,videos")
                .map { tvEpisodeMapper.transform(it) }
    }
}