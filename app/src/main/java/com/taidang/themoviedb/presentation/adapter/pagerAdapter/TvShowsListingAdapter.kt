package com.taidang.themoviedb.presentation.adapter.pagerAdapter

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import com.taidang.themoviedb.R
import com.taidang.themoviedb.domain.model.ImagesConfig
import com.taidang.themoviedb.domain.model.TvShow
import com.taidang.themoviedb.extension.inflate
import com.taidang.themoviedb.presentation.adapter.viewholder.TvShowItemVH

/**
 * Created by thuyhien on 5/8/18.
 */
class TvShowsListingAdapter(private val tvShows: List<TvShow>,
                            private val imagesConfig: ImagesConfig,
                            private val itemClickListener: (TvShow) -> Unit) : RecyclerView.Adapter<TvShowItemVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowItemVH {
        val vh = TvShowItemVH(parent.inflate(R.layout.item_tv_show))
        vh.itemView.setOnClickListener {
            itemClickListener(tvShows[vh.adapterPosition])
        }

        vh.itemView.findViewById<ImageView>(R.id.vStar).apply {
            drawable.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(context, R.color.colorAccent), PorterDuff.Mode.SRC_IN)
        }
        return vh
    }

    override fun getItemCount(): Int = tvShows.size

    override fun onBindViewHolder(holder: TvShowItemVH, position: Int) {
        holder.bind(tvShows[position], imagesConfig)
    }

}