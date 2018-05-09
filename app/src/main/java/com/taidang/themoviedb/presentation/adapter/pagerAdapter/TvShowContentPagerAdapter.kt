package com.taidang.themoviedb.presentation.adapter.pagerAdapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.taidang.themoviedb.R
import com.taidang.themoviedb.presentation.fragment.PopularTvShowsFragment
import com.taidang.themoviedb.presentation.fragment.TopRatedTvShowsFragment

/**
 * Created by thuyhien on 5/7/18.
 */
class TvShowContentPagerAdapter(private val context: Context, fragmentManager : FragmentManager)
    : FragmentPagerAdapter(fragmentManager) {
    companion object {
        private const val TOTAL_PAGES = 2
        private const val INDEX_POPULAR = 0
        private const val INDEX_TOP_RATED = 1
    }

    override fun getItem(position: Int): Fragment = when(position) {
        INDEX_POPULAR -> PopularTvShowsFragment()
        INDEX_TOP_RATED -> TopRatedTvShowsFragment()
        else -> throw IllegalArgumentException()
    }

    override fun getPageTitle(position: Int): String = when(position) {
        INDEX_POPULAR -> context.getString(R.string.tab_name_popular_tv_show)
        INDEX_TOP_RATED -> context.getString(R.string.tab_name_top_rated_tv_show)
        else -> throw IllegalArgumentException()
    }

    override fun getCount(): Int = TOTAL_PAGES
}