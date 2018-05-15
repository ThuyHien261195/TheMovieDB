package com.taidang.themoviedb.repository.mapper

import com.google.gson.JsonElement
import com.taidang.themoviedb.domain.model.GuestStar
import com.taidang.themoviedb.domain.model.TvEpisode
import com.taidang.themoviedb.domain.model.TvEpisodeDetails
import com.taidang.themoviedb.repository.response.TvEpisodeEntity

/**
 * Created by thuyhien on 5/14/18.
 */
class TvEpisodeDetailsMapper(private val castMapper: CastMapper,
                             private val crewMapper: CrewMapper,
                             private val clipMapper: ClipMapper)
    : IMapper<TvEpisodeEntity, TvEpisodeDetails> {
    override fun transform(entity: TvEpisodeEntity): TvEpisodeDetails {
        val crews = crewMapper.transform(entity.credits.crew)
        val casts = castMapper.transform(entity.credits.cast)
        val clips = clipMapper.transform(entity.videos?.results!!)
        val guestStars = parseGuestStars(entity.guest_stars)
        return TvEpisodeDetails(casts, crews, clips, guestStars)
    }

    private fun parseGuestStars(element: JsonElement): List<GuestStar> {
        return if (!element.isJsonArray) emptyList()
        else {
            element.asJsonArray
                    .filter { it.isJsonObject }
                    .map { it.asJsonObject }
                    .filter { !it.get("profile_path").isJsonNull }
                    .map {
                        GuestStar(it.get("id").asInt, it.get("name").asString,
                                it.get("credit_id").asString, it.get("character").asString,
                                it.get("order").asInt, it.get("profile_path").asString)
                    }
        }
    }
}