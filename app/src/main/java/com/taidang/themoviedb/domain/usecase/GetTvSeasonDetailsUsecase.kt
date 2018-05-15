package com.taidang.themoviedb.domain.usecase

import com.taidang.themoviedb.domain.SchedulerFactory
import com.taidang.themoviedb.domain.TvSeasonRepository
import com.taidang.themoviedb.domain.model.TvSeason
import io.reactivex.Single

/**
 * Created by thuyhien on 5/14/18.
 */
class GetTvSeasonDetailsUsecase(schedulerFactory: SchedulerFactory, private val tvSeasonRepository: TvSeasonRepository)
    : BaseUsecase(schedulerFactory){
    fun getTvSeasonDetails(tvShowId: Int, tvSeasonNum: Int) : Single<TvSeason> {
        return tvSeasonRepository.getTvSeasonDetails(tvShowId, tvSeasonNum)
                .subscribeOn(schedulerFactory.workerScheduler())
                .observeOn(schedulerFactory.callbackScheduler())
    }
}