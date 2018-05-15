package com.taidang.themoviedb.domain.model

/**
 * Created by thuyhien on 5/4/18.
 */
class TvSeason(
        val id: Int,
        val airDate: Long,
        val episodeCount: Int,
        val posterPath: String?,
        val seasonNumber: Int,
        val seasonDetails: TvSeasonDetails?)