package com.taidang.themoviedb.presentation.adapter.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.taidang.themoviedb.R
import com.taidang.themoviedb.domain.model.ImageSize
import com.taidang.themoviedb.domain.model.ImagesConfig
import com.taidang.themoviedb.domain.model.TvSeason
import kotlinx.android.synthetic.main.item_season.*

/**
 * Created by thuyhien on 5/11/18.
 */
class TvSeasonItemVH(itemView: View, private val imagesConfig: ImagesConfig) : BaseViewHolder<TvSeason>(itemView) {
    override fun bind(data: TvSeason) {
        with(data) {
            Glide.with(getContext())
                    .load(imagesConfig.buildPosterUrl(posterPath, ImageSize.MEDIUM))
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(ivSeasonPic)
            tvSeasonName.text = "${getContext().getString(R.string.label_season)} $seasonNumber"
            tvEpisodeCount.text = getContext().getString(R.string.label_episode_count) + episodeCount
        }
    }
}