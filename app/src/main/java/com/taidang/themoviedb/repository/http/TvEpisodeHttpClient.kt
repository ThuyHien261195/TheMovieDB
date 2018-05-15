package com.taidang.themoviedb.repository.http

import com.taidang.themoviedb.domain.model.TvEpisode
import com.taidang.themoviedb.repository.response.TvEpisodeEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by thuyhien on 5/14/18.
 */
interface TvEpisodeHttpClient {
    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}")
    fun getTvEpisodeDetails(@Path("tv_id") tvShowId: Int,
                            @Path("season_number") tvSeasonNum: Int,
                            @Path("episode_number") tvEpisodeNum: Int,
                            @Query("language") language: String,
                            @Query("append_to_response") append: String) : Single<TvEpisodeEntity>
}