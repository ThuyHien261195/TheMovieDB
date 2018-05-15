package com.taidang.themoviedb.repository.response

import com.google.gson.JsonElement
import java.util.*

/**
 * Created by thuyhien on 5/7/18.
 */
class TvShowEntity (
    // Series list item
    val id: Int,
    val poster_path: String?,
    val first_air_date: Date,
    val name: String,
    val backdrop_path: String?,
    val vote_count: Int,
    val vote_average: Float,

    // Series details
    val videos: ClipResponse,
    val homepage: String?,
    val genres: JsonElement?, // too lazy to create entity and mapper
    val overview: String,
    val production_companies: JsonElement, // too lazy to create entity and mapper
    val status: String,
    val tagline: String?,
    val imdb_id: String,
    val popularity: String,
    val credits: CreditsResponse,
    val keywords: JsonElement, // too lazy to create entity and mapper
    val contentRatings: JsonElement,
    val seasons: List<TvSeasonEntity>
)