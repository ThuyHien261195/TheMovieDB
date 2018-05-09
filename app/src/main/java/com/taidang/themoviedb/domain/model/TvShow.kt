package com.taidang.themoviedb.domain.model

/**
 * Created by thuyhien on 5/4/18.
 */
class TvShow(val id: Int,
             val title: String,
             val firstAirDate: Long,
             val posterPath: String?,
             val backdropPath: String?,
             val vote: Float,
             val details: TvShowDetails?) {
    fun getTMDbRating() = "TMDb $vote"
}