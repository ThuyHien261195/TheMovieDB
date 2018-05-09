package com.taidang.themoviedb.domain.model

/**
 * Created by thuyhien on 5/4/18.
 */
class TvShowDetails(val duration: Int,
                    val genres: List<String>,
                    val description: String,
                    val casts: List<Cast>,
                    val clips: List<Clip>,
                    val companies: List<Company>,
                    val status: String,
                    val homepage: String,
                    val tagline: String,
                    val keywords: List<String>,
                    val contentRating: List<String>,
                    val seasons: List<SeasonOfTvShow>) {

    fun getDurationStr(): String {
        val hour = duration / 60
        val min = duration % 60
        return if (hour <= 0) "$min min"
        else "$hour hour $min min"
    }
}