package com.taidang.themoviedb.repository

import com.taidang.themoviedb.domain.TvSeasonRepository
import com.taidang.themoviedb.domain.model.TvSeason
import com.taidang.themoviedb.repository.http.TvSeasonHttpClient
import com.taidang.themoviedb.repository.mapper.TvSeasonDetailsMapper
import com.taidang.themoviedb.repository.mapper.TvSeasonMapper
import io.reactivex.Single

/**
 * Created by thuyhien on 5/14/18.
 */
class TvSeasonRemoteDataStore(private val tvSeasonHttpClient: TvSeasonHttpClient,
                              private val tvSeasonMapper: TvSeasonMapper) : TvSeasonRepository {
    override fun getTvSeasonDetails(tvShowId: Int, tvSeasonNum: Int): Single<TvSeason> {
        return tvSeasonHttpClient.getSeasonDetails(tvShowId, tvSeasonNum, "en-US", "credits,videos")
                .map { tvSeasonMapper.transform(it) }
    }
}