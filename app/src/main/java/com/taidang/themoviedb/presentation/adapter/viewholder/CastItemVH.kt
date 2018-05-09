package com.taidang.themoviedb.presentation.adapter.viewholder

import android.view.View
import com.taidang.themoviedb.domain.model.Cast
import com.taidang.themoviedb.domain.model.ImagesConfig
import kotlinx.android.synthetic.main.item_cast.*

class CastItemVH(itemView: View, private val imagesConfig: ImagesConfig) : BaseViewHolder<Cast>(itemView) {
    override fun bind(data: Cast) {
        with(data) {
            com.bumptech.glide.Glide.with(getContext())
                    .load(imagesConfig.buildProfileUrl(profile_path, com.taidang.themoviedb.domain.model.ImageSize.MEDIUM))
                    .transition(com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade())
                    .into(ivCastPic)
            tvCastName.text = name
            tvCastCharacter.text = character
        }
    }
}