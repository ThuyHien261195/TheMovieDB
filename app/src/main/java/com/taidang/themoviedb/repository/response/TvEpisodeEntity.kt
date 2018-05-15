package com.taidang.themoviedb.repository.response

import com.google.gson.JsonElement
import com.taidang.themoviedb.domain.model.Cast
import com.taidang.themoviedb.domain.model.Clip
import com.taidang.themoviedb.domain.model.Crew
import com.taidang.themoviedb.domain.model.GuestStar
import java.util.*

/**
 * Created by thuyhien on 5/11/18.
 */
class TvEpisodeEntity(
        // Episode list item
        val air_date: Date?,
        val episode_number: Int,
        val name: String,
        val overview: String,
        val vote_average: Float,
        val still_path: String?,

        // Episode details
        val credits: CreditsResponse,
        val videos: ClipResponse?,
        val guest_stars: JsonElement
)