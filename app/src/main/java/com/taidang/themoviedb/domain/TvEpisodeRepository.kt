package com.taidang.themoviedb.domain

import com.taidang.themoviedb.domain.model.TvEpisode
import com.taidang.themoviedb.domain.model.TvSeason
import io.reactivex.Single

/**
 * Created by thuyhien on 5/14/18.
 */
interface TvEpisodeRepository {
    fun getTvEpisodeDetails(tvShowId: Int, tvSeasonNum: Int, tvEpisodeNum: Int): Single<TvEpisode>
}