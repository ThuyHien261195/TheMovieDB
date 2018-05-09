package com.taidang.themoviedb.domain

import com.taidang.themoviedb.domain.model.TvShow
import com.taidang.themoviedb.domain.model.TvShowsInfo
import io.reactivex.Single

/**
 * Created by thuyhien on 5/4/18.
 */
interface TvShowRepository {
    fun getPopularTvShows(language: String, page: Int) : Single<TvShowsInfo>
    fun getTopRatedTvShows(language: String, page: Int) : Single<TvShowsInfo>
    fun getTvShowDetails(id: Int) : Single<TvShow>
}