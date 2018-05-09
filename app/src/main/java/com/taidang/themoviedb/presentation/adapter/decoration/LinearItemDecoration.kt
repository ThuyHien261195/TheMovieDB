package com.taidang.themoviedb.presentation.adapter.decoration

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by thuyhien on 5/9/18.
 */
class LinearItemDecoration(private val spacing: Int,
                           private val includeEdge: Boolean,
                           private val headerNum: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        val position = parent.getChildAdapterPosition(view) - headerNum

        if (position >= 0) {
            if (includeEdge) {
                if (position == 0) {
                    outRect.top = spacing
                }
                outRect.bottom = spacing
            } else {
                if (position > 0) {
                    outRect.top = spacing
                }
            }
        } else {
            outRect.top = 0
            outRect.bottom = 0
        }
    }
}