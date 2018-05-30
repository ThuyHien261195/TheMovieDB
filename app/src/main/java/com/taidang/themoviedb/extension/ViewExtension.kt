package com.taidang.themoviedb.extension

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.taidang.themoviedb.R
import kotlinx.android.synthetic.main.include_tab_media.*

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.isShowing() = this.visibility == View.VISIBLE

fun ViewGroup.inflate(@LayoutRes layoutResId: Int): View {
    return LayoutInflater.from(context).inflate(layoutResId, this, false)
}

fun RecyclerView.configHorizontalListView(context: Context) {
    this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    this.setHasFixedSize(true)

    ContextCompat.getDrawable(context, R.drawable.cast_listing_divider)?.let {
        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
        dividerItemDecoration.setDrawable(it)
        this.addItemDecoration(dividerItemDecoration)
    }
}

fun Button.setSelectedBackground(context: Context) {
    this.setTextColor(ContextCompat.getColor(context, R.color.text_dark_blue))
    DrawableCompat.setTint(this.compoundDrawables[1], ContextCompat.getColor(context, R.color.text_dark_blue))
}

fun Button.setUnselectedBackground(context: Context) {
    this.setTextColor(ContextCompat.getColor(context, android.R.color.black))
    DrawableCompat.setTint(this.compoundDrawables[1], ContextCompat.getColor(context, android.R.color.black))
}