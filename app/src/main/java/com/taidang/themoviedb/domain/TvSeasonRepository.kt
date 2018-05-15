package com.taidang.themoviedb.domain

import com.taidang.themoviedb.domain.model.TvSeason
import io.reactivex.Single

/**
 * Created by thuyhien on 5/14/18.
 */
interface TvSeasonRepository {
    fun getTvSeasonDetails(tvShowId: Int, tvSeasonNum: Int) : Single<TvSeason>
}