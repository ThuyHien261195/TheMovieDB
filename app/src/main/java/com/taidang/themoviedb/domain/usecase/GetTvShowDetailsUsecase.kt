package com.taidang.themoviedb.domain.usecase

import com.taidang.themoviedb.domain.SchedulerFactory
import com.taidang.themoviedb.domain.TvShowRepository
import com.taidang.themoviedb.domain.model.TvShow
import io.reactivex.Single

/**
 * Created by thuyhien on 5/4/18.
 */
class GetTvShowDetailsUsecase(schedulerFactory: SchedulerFactory, private val tvShowRepository: TvShowRepository)
    : BaseUsecase(schedulerFactory) {
    fun getSeriesDetails(id: Int) : Single<TvShow> {
        return tvShowRepository.getTvShowDetails(id)
                .subscribeOn(schedulerFactory.workerScheduler())
                .observeOn(schedulerFactory.callbackScheduler())
    }
}