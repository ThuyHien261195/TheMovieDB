package com.taidang.themoviedb.presentation.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer

/**
 * Created by thuyhien on 5/8/18.
 */
abstract class BaseViewHolder<in E>(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    abstract fun bind(data: E)

    fun getContext() = containerView.context
}