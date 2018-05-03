package com.taidang.themoviedb.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.taidang.themoviedb.R
import com.taidang.themoviedb.presentation.adapter.MainContentPagerAdapter
import com.taidang.themoviedb.presentation.adapter.ZoomOutPageTransformer
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.support.v4.onPageChangeListener

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainContentPagerAdapter(this, supportFragmentManager)
        vMainPager.adapter = adapter
        vMainPager.setPageTransformer(true, ZoomOutPageTransformer())
        vMainPager.onPageChangeListener {
            onPageSelected { vToolbar.title = adapter.getPageTitle(it) }
        }

        vToolbar.title = adapter.getPageTitle(vMainPager.currentItem)
    }
}
