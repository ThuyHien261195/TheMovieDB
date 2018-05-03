package com.taidang.themoviedb.presentation.activity

import android.support.v7.app.AppCompatActivity
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.longToast

open abstract class BaseActivity : DaggerAppCompatActivity() {

    fun showErrorMessage(error: String?) {
        longToast("Oops! $error")
    }
}