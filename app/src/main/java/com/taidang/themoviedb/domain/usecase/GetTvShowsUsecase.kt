package com.taidang.themoviedb.domain.usecase

import com.taidang.themoviedb.domain.SchedulerFactory
import com.taidang.themoviedb.domain.TvShowRepository
import com.taidang.themoviedb.domain.model.TvShowsInfo
import io.reactivex.Single

/**
 * Created by thuyhien on 5/4/18.
 */
class GetTvShowsUsecase(schedulerFactory: SchedulerFactory, private val seriesRepository: TvShowRepository)
    : BaseUsecase(schedulerFactory) {

    fun getPopularTvShows(language: String = "en", page: Int = 1) : Single<TvShowsInfo> {
        return seriesRepository.getPopularTvShows(language, page)
                .subscribeOn(schedulerFactory.workerScheduler())
                .observeOn(schedulerFactory.callbackScheduler())
    }

    fun getTopRatedTvShows(language: String = "en", page: Int = 1) : Single<TvShowsInfo> {
        return seriesRepository.getTopRatedTvShows(language, page)
                .subscribeOn(schedulerFactory.workerScheduler())
                .observeOn(schedulerFactory.callbackScheduler())
    }
}