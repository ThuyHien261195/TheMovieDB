package com.taidang.themoviedb.domain.model

/**
 * Created by thuyhien on 5/11/18.
 */
class TvEpisode (
        val airDate: Long,
        val episodeNumber: Int,
        val name: String,
        val overview: String,
        val vote: Float,
        val stillPath: String?,
        val tvEpisodeDetails: TvEpisodeDetails?)