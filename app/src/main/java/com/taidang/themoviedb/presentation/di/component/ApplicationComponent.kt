package com.taidang.themoviedb.presentation.di.component

import com.taidang.themoviedb.di.module.NetworkModule
import com.taidang.themoviedb.di.module.RepositoryModule
import com.taidang.themoviedb.presentation.TMDBApp
import com.taidang.themoviedb.presentation.di.ApplicationScoped
import com.taidang.themoviedb.presentation.di.module.common.ActivityBuilderModule
import com.taidang.themoviedb.presentation.di.module.common.ApplicationModule
import com.taidang.themoviedb.presentation.di.module.common.MapperModule
import com.taidang.themoviedb.presentation.di.module.common.UsecaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

@ApplicationScoped
@Component(modules = [
    ApplicationModule::class,
    RepositoryModule::class,
    NetworkModule::class,
    MapperModule::class,
    UsecaseModule::class,
    ActivityBuilderModule::class,
    AndroidSupportInjectionModule::class])
interface ApplicationComponent: AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun bindsApplication(application: TMDBApp): Builder
    }
}