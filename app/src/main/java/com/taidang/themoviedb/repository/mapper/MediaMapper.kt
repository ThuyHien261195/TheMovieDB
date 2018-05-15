package com.taidang.themoviedb.repository.mapper

import com.google.gson.JsonElement
import com.taidang.themoviedb.domain.model.Company

/**
 * Created by thuyhien on 5/7/18.
 */
class MediaMapper {
    companion object {
        public fun parseGenres(element: JsonElement): List<String> {
            return if (!element.isJsonArray) emptyList()
            else {
                element.asJsonArray
                        .filter { it.isJsonObject }
                        .map { it.asJsonObject }
                        .filter { !it.get("name").isJsonNull }
                        .map { it.get("name").asString }
            }
        }

        public fun  parseCompanies(element: JsonElement): List<Company> {
            return if (!element.isJsonArray) emptyList()
            else {
                element.asJsonArray
                        .filter { it.isJsonObject }
                        .map { it.asJsonObject }
                        .filter { !it.get("logo_path").isJsonNull }
                        .map {
                            Company(it.get("id").asInt, it.get("name").asString, it.get("logo_path").asString)
                        }
            }
        }

        public fun parseCountries(element: JsonElement): List<String> {
            return if (!element.isJsonArray) emptyList()
            else {
                element.asJsonArray
                        .filter { it.isJsonObject }
                        .map { it.asJsonObject }
                        .filter { !it.get("name").isJsonNull }
                        .map { it.get("name").asString }
            }
        }
    }
}