package com.taidang.themoviedb.repository.response

import java.util.*

/**
 * Created by thuyhien on 5/11/18.
 */
class TvSeasonEntity (
    // Season list item
    val id: Int,
    val air_date: Date?,
    val episode_count: Int,
    val poster_path: String?,
    val season_number: Int,
    val episodes: List<TvEpisodeEntity>,

    // Season details
    val name: String,
    val overview: String,
    val credits: CreditsResponse,
    val videos: ClipResponse?
)