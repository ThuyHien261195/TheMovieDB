package com.taidang.themoviedb.presentation

import com.taidang.themoviedb.presentation.di.component.ApplicationComponent
import com.taidang.themoviedb.presentation.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class TMDBApp : DaggerApplication() {

    private lateinit var appComponent: ApplicationComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerApplicationComponent.builder()
                .bindsApplication(this)
                .build()
        return appComponent
    }
}