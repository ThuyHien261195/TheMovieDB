package com.taidang.themoviedb.domain.model

/**
 * Created by thuyhien on 5/4/18.
 */
class TvShowDetails(val genres: List<String>,
                    val description: String,
                    val casts: List<Cast>,
                    val clips: List<Clip>,
                    val companies: List<Company>,
                    val status: String,
                    val homepage: String,
                    val tagline: String,
                    val keywords: List<String>,
                    val contentRating: List<String>,
                    val seasons: List<TvSeason>) {

    fun getSeasonNumber() = "${seasons.size} Sections"
}