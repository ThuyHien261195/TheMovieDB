package com.taidang.themoviedb.presentation.di.module

import com.taidang.themoviedb.domain.usecase.GetConfigUsecase
import com.taidang.themoviedb.presentation.contract.SplashContract
import com.taidang.themoviedb.presentation.manager.AppConfigManager
import com.taidang.themoviedb.presentation.presenter.SplashPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class SplashModule {

    @Binds
    abstract fun providesSplashPresenter(splashPresenter: SplashPresenter): SplashContract.Presenter
}