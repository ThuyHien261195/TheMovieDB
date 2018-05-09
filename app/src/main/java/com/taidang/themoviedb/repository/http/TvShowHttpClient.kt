package com.taidang.themoviedb.repository.http

import com.taidang.themoviedb.repository.response.MovieEntity
import com.taidang.themoviedb.repository.response.MoviesListResponse
import com.taidang.themoviedb.repository.response.TvShowEntity
import com.taidang.themoviedb.repository.response.TvShowsListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by thuyhien on 5/7/18.
 */
interface TvShowHttpClient {
    @GET("tv/popular")
    fun getPopularTvShows(@Query("language") language: String, @Query("page") page: Int) : Single<TvShowsListResponse>

    @GET("tv/top_rated")
    fun getTopRatedTvShows(@Query("language") language: String, @Query("page") page: Int) : Single<TvShowsListResponse>

    @GET("tv/{tv_id}")
    fun getTvShowDetails(@Path("tv_id") id: Int,
                         @Query("language") language: String,
                         @Query("append_to_response") append: String) : Single<TvShowEntity>
}