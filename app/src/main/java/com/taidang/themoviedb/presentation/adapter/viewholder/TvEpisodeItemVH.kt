package com.taidang.themoviedb.presentation.adapter.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.taidang.themoviedb.domain.model.ImageSize
import com.taidang.themoviedb.domain.model.ImagesConfig
import com.taidang.themoviedb.domain.model.TvEpisode
import kotlinx.android.synthetic.main.item_episode.*

/**
 * Created by thuyhien on 5/14/18.
 */
class TvEpisodeItemVH(itemView: View,
                      private val imagesConfig: ImagesConfig) : BaseViewHolder<TvEpisode>(itemView) {
    override fun bind(data: TvEpisode) {
        Glide.with(getContext())
                .load(imagesConfig.buildPosterUrl(data.stillPath, ImageSize.MEDIUM))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivEpisodePic)
        tvEpisodeName.text = data.name
    }
}