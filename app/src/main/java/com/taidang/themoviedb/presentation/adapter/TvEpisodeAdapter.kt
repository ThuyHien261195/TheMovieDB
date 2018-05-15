package com.taidang.themoviedb.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.taidang.themoviedb.R
import com.taidang.themoviedb.domain.model.ImagesConfig
import com.taidang.themoviedb.domain.model.TvEpisode
import com.taidang.themoviedb.extension.inflate
import com.taidang.themoviedb.presentation.adapter.viewholder.TvEpisodeItemVH

/**
 * Created by thuyhien on 5/14/18.
 */
class TvEpisodeAdapter(private val tvEpisodes: List<TvEpisode>,
                       private val imagesConfig: ImagesConfig,
                       private val itemSelectListener: (TvEpisode) -> Unit)
    : RecyclerView.Adapter<TvEpisodeItemVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvEpisodeItemVH {
        val viewHolder = TvEpisodeItemVH(parent.inflate(R.layout.item_episode), imagesConfig)

        viewHolder.itemView.setOnClickListener {
            itemSelectListener(tvEpisodes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int = tvEpisodes.size

    override fun onBindViewHolder(holder: TvEpisodeItemVH, position: Int) {
        holder.bind(tvEpisodes[position])
    }
}