package com.taidang.themoviedb.repository.http

import com.taidang.themoviedb.repository.response.TvSeasonEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by thuyhien on 5/14/18.
 */
interface TvSeasonHttpClient {
    @GET("tv/{tv_id}/season/{season_number}")
    fun getSeasonDetails(@Path("tv_id") tvId: Int,
                         @Path("season_number") tvSeasonNum: Int,
                         @Query("language") language: String,
                         @Query("append_to_response") append: String) : Single<TvSeasonEntity>

}