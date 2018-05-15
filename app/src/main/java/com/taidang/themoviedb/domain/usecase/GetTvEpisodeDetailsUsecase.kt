package com.taidang.themoviedb.domain.usecase

import com.taidang.themoviedb.domain.SchedulerFactory
import com.taidang.themoviedb.domain.TvEpisodeRepository
import com.taidang.themoviedb.domain.model.TvEpisode
import io.reactivex.Single

/**
 * Created by thuyhien on 5/14/18.
 */
class GetTvEpisodeDetailsUsecase(schedulerFactory: SchedulerFactory, private val tvEpisodeRepository: TvEpisodeRepository)
    : BaseUsecase(schedulerFactory) {
    fun getTvEpisodeDetails(tvShowId: Int, tvSeasonNum: Int, tvEpisodeNum: Int) : Single<TvEpisode> {
        return tvEpisodeRepository.getTvEpisodeDetails(tvShowId, tvSeasonNum, tvEpisodeNum)
                .subscribeOn(schedulerFactory.workerScheduler())
                .observeOn(schedulerFactory.callbackScheduler())
    }
}