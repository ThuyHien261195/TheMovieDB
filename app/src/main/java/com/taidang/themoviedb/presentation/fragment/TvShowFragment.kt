package com.taidang.themoviedb.presentation.fragment

import android.os.Bundle
import android.view.View
import com.taidang.themoviedb.presentation.adapter.pagerAdapter.TvShowContentPagerAdapter
import com.taidang.themoviedb.presentation.adapter.ZoomOutPageTransformer
import kotlinx.android.synthetic.main.fragment_media.*
import org.jetbrains.anko.support.v4.onPageChangeListener

/**
 * Created by thuyhien on 5/8/18.
 */
class TvShowFragment : BaseMediaPagerFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TvShowContentPagerAdapter(this.context!!, this.childFragmentManager)
        vMainPager.adapter = adapter
        vMainPager.setPageTransformer(true, ZoomOutPageTransformer())
        vMainPager.onPageChangeListener {
            onPageSelected {
                pageSelectedListener?.onPageSelected(adapter.getPageTitle(it))
            }
        }

        pageSelectedListener?.onPageSelected(adapter.getPageTitle(vMainPager.currentItem))
    }
}