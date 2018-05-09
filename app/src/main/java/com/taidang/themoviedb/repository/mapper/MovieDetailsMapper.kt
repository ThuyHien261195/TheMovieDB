package com.taidang.themoviedb.repository.mapper

import com.google.gson.JsonElement
import com.taidang.themoviedb.domain.model.MovieDetails
import com.taidang.themoviedb.repository.mapper.MediaMapper.Companion.parseCompanies
import com.taidang.themoviedb.repository.mapper.MediaMapper.Companion.parseCountries
import com.taidang.themoviedb.repository.mapper.MediaMapper.Companion.parseGenres
import com.taidang.themoviedb.repository.mapper.MediaMapper.Companion.parseKeywords
import com.taidang.themoviedb.repository.response.MovieEntity

class MovieDetailsMapper(private val castMapper: CastMapper, private val clipMapper: ClipMapper) : IMapper<MovieEntity, MovieDetails> {
    override fun transform(entity: MovieEntity): MovieDetails {
        val genres = parseGenres(entity.genres!!)
        val companies = parseCompanies(entity.production_companies)
        val countries = parseCountries(entity.production_countries)
        val keywords = parseKeywords(entity.keywords)
        val casts = castMapper.transform(entity.credits.cast)
        val clips = clipMapper.transform(entity.videos.results)
        val contentRating = parseCertification(entity.release_dates)
        return MovieDetails(
                entity.runtime,
                genres,
                entity.overview,
                casts,
                clips,
                companies,
                countries,
                entity.status,
                entity.homepage ?: "",
                entity.tagline ?: "",
                keywords,
                contentRating)
    }

    public fun parseCertification(element: JsonElement, country: String = "US"): String? {
        return if (!element.isJsonObject) ""
        else {
            element.asJsonObject.get("results").asJsonArray
                    .map { it.asJsonObject }
                    .filter { it.get("iso_3166_1").asString.equals(country, true) }
                    .flatMap { it.get("release_dates").asJsonArray }
                    .filter {
                        val value: JsonElement = it.asJsonObject.get("certification")
                        value.isJsonPrimitive && value.asString.isNotEmpty()
                    }
                    .map { it.asJsonObject.get("certification").asString }
                    .singleOrNull()
        }
    }
}