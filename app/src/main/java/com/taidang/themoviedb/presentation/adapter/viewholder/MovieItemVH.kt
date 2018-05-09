package com.taidang.themoviedb.presentation.adapter.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.taidang.themoviedb.domain.model.ImageSize
import com.taidang.themoviedb.domain.model.ImagesConfig
import com.taidang.themoviedb.domain.model.Movie
import kotlinx.android.synthetic.main.item_now_playing_movie_port.*

class MovieItemVH(itemView: View) : BaseViewHolder<Movie>(itemView) {
    override fun bind(data: Movie) {
        tvMovieVote.text = data.vote.toString()
    }

    fun bind(movie: Movie, imagesConfig: ImagesConfig) {
        bind(movie)
        Glide.with(getContext())
                .load(imagesConfig.buildPosterUrl(movie.posterPath, ImageSize.MEDIUM))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivMovieBackdrop)
    }
}