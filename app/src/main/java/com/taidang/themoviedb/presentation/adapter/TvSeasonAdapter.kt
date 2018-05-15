package com.taidang.themoviedb.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.taidang.themoviedb.R
import com.taidang.themoviedb.domain.model.ImagesConfig
import com.taidang.themoviedb.domain.model.TvSeason
import com.taidang.themoviedb.extension.inflate
import com.taidang.themoviedb.presentation.adapter.viewholder.TvSeasonItemVH

/**
 * Created by thuyhien on 5/11/18.
 */
class TvSeasonAdapter(private val seasons: List<TvSeason>,
                      private val imagesConfig: ImagesConfig,
                      private val itemSelectListener: (TvSeason) -> Unit) :
        RecyclerView.Adapter<TvSeasonItemVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvSeasonItemVH {
        val viewHolder = TvSeasonItemVH(parent.inflate(R.layout.item_season), imagesConfig)

        viewHolder.itemView.setOnClickListener {
            itemSelectListener(seasons[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int = seasons.size


    override fun onBindViewHolder(holder: TvSeasonItemVH, position: Int) {
        holder.bind(seasons[position])
    }
}