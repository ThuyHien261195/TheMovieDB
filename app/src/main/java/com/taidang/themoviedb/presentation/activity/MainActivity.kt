package com.taidang.themoviedb.presentation.activity

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.widget.Button
import com.taidang.themoviedb.R
import com.taidang.themoviedb.extension.enum.FragmentType
import com.taidang.themoviedb.extension.setSelectedBackground
import com.taidang.themoviedb.extension.setUnselectedBackground
import com.taidang.themoviedb.presentation.fragment.MovieFragment
import com.taidang.themoviedb.presentation.fragment.TvShowFragment
import com.taidang.themoviedb.presentation.listener.PageSelectedListener
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_tab_media.*

class MainActivity : DaggerAppCompatActivity(), PageSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        miMovie.setOnClickListener{
            showFragment(FragmentType.MOVIE)
        }

        miSeries.setOnClickListener{
            showFragment(FragmentType.TVSHOWS)
        }

        showFragment(FragmentType.MOVIE)
    }

    override fun onPageSelected(title: String) {
        vToolbar.title = title
    }

    private fun showFragment(fragmentType: FragmentType) {
        setBottomButtonBackground(fragmentType)
        val fragmentTransition : FragmentTransaction = supportFragmentManager.beginTransaction()
        when(fragmentType) {
            FragmentType.MOVIE -> fragmentTransition.replace(R.id.frameLayoutMain, MovieFragment())
            FragmentType.TVSHOWS -> fragmentTransition.replace(R.id.frameLayoutMain, TvShowFragment())
        }
        fragmentTransition.commit()
    }

    private fun setBottomButtonBackground(fragmentType: FragmentType) {
        when(fragmentType) {
            FragmentType.MOVIE -> {
                miMovie.setActive()
                miSeries.setInActive()
            }
            FragmentType.TVSHOWS -> {
                miSeries.setActive()
                miMovie.setInActive()
            }
        }
    }
}
