package com.taidang.themoviedb.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.taidang.themoviedb.R
import com.taidang.themoviedb.presentation.listener.PageSelectedListener
import dagger.android.support.DaggerFragment

/**
 * Created by thuyhien on 5/8/18.
 */
abstract class BaseMediaPagerFragment : DaggerFragment() {
    protected var pageSelectedListener: PageSelectedListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        pageSelectedListener = context as PageSelectedListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_media, container, false)
    }

    override fun onDetach() {
        super.onDetach()
        pageSelectedListener = null
    }
}