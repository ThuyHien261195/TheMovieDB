package com.taidang.themoviedb.presentation.adapter.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.taidang.themoviedb.domain.model.ImageSize
import com.taidang.themoviedb.domain.model.ImagesConfig
import com.taidang.themoviedb.domain.model.TvShow
import kotlinx.android.synthetic.main.item_now_playing_movie_port.*

/**
 * Created by thuyhien on 5/8/18.
 */
class TvShowItemVH(itemView: View) : BaseViewHolder<TvShow>(itemView) {
    override fun bind(data: TvShow) {
        tvMovieVote.text = data.vote.toString()
    }

    fun bind(tvShow: TvShow, imagesConfig: ImagesConfig) {
        bind(tvShow)
        Glide.with(getContext())
                .load(imagesConfig.buildBackdropUrl(tvShow.backdropPath, ImageSize.MEDIUM))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivMovieBackdrop)
    }
}