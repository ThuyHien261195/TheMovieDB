package com.taidang.themoviedb.domain.model

/**
 * Created by thuyhien on 5/11/18.
 */
class TvSeasonDetails(
        val name: String,
        val overview: String,
        val casts: List<Cast>,
        val clips: List<Clip>,
        val episodes: List<TvEpisode>) {

    fun getTvEpisodeNumber() = "${episodes.size} Episodes"
}
