package com.taidang.themoviedb.domain.model

/**
 * Created by thuyhien on 5/11/18.
 */
class GuestStar(
        val id: Int,
        val name: String,
        val creditId: String,
        val character: String,
        val order: Int,
        val profilePath: String?
)