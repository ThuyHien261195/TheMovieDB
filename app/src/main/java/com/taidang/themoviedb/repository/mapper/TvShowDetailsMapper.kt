package com.taidang.themoviedb.repository.mapper

import com.google.gson.JsonElement
import com.taidang.themoviedb.domain.model.TvSeason
import com.taidang.themoviedb.domain.model.TvShowDetails
import com.taidang.themoviedb.repository.mapper.MediaMapper.Companion.parseCompanies
import com.taidang.themoviedb.repository.mapper.MediaMapper.Companion.parseGenres
import com.taidang.themoviedb.repository.response.TvShowEntity

/**
 * Created by thuyhien on 5/7/18.
 */
class TvShowDetailsMapper(private val castMapper: CastMapper,
                          private val clipMapper: ClipMapper,
                          private val tvSeasonMapper: TvSeasonMapper)
    : IMapper<TvShowEntity, TvShowDetails> {
    override fun transform(entity: TvShowEntity): TvShowDetails {
        val genres = parseGenres(entity.genres!!)
        val casts = castMapper.transform(entity.credits.cast)
        val clips = clipMapper.transform(entity.videos.results)
        val companies = parseCompanies(entity.production_companies)
        val keywords = parseKeywords(entity.keywords)
        val contentRatings = parseContentRating(entity.contentRatings)
        val seasons = tvSeasonMapper.transform(entity.seasons)
        return TvShowDetails(genres,
                entity.overview,
                casts,
                clips,
                companies,
                entity.status,
                entity.homepage ?: "",
                entity.tagline ?: "",
                keywords,
                contentRatings,
                seasons)
    }

    private fun parseContentRating(elemnet: JsonElement): List<String> {
        return if (!elemnet.isJsonObject) ArrayList<String>()
        else {
            elemnet.asJsonObject.get("results").asJsonArray
                    .filter { it.isJsonObject }
                    .map { it.asJsonObject }
                    .filter { !it.get("iso_3166_1").isJsonNull }
                    .map { it.get("iso_3166_1").asString + ": " + it.get("rating").asString }
        }
    }

    private fun parseKeywords(element: JsonElement): List<String> {
        return if (!element.isJsonObject) emptyList()
        else {
            element.asJsonObject.get("results").asJsonArray
                    .map { it.asJsonObject }
                    .filter { !it.get("name").isJsonNull }
                    .map { it.get("name").asString }
        }
    }
}