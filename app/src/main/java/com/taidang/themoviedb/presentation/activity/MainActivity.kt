package com.taidang.themoviedb.presentation.activity

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import com.taidang.themoviedb.R
import com.taidang.themoviedb.extension.enum.FragmentType
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

        btnMovie.setOnClickListener{
            showFragment(FragmentType.MOVIE)
        }

        btnSeries.setOnClickListener{
            showFragment(FragmentType.TVSHOWS)
        }

        showFragment(FragmentType.MOVIE)
    }

    private fun showFragment(fragmentType: FragmentType) {
        val fragmentTransition : FragmentTransaction = supportFragmentManager.beginTransaction()
        when(fragmentType) {
            FragmentType.MOVIE -> fragmentTransition.replace(R.id.frameLayoutMain, MovieFragment())
            FragmentType.TVSHOWS -> fragmentTransition.replace(R.id.frameLayoutMain, TvShowFragment())
            else -> fragmentTransition.replace(R.id.frameLayoutMain, MovieFragment())
        }
        fragmentTransition.commit()
    }

    override fun onPageSelected(title: String) {
        vToolbar.title = title
    }
}
