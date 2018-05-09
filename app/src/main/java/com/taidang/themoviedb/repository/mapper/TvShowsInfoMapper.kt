package com.taidang.themoviedb.repository.mapper

import com.taidang.themoviedb.domain.model.TvShowsInfo
import com.taidang.themoviedb.repository.response.TvShowsListResponse

/**
 * Created by thuyhien on 5/7/18.
 */
class TvShowsInfoMapper(private val tvShowMapper: TvShowMapper)
    : IMapper<TvShowsListResponse, TvShowsInfo> {
    override fun transform(entity: TvShowsListResponse): TvShowsInfo {
        return TvShowsInfo(
                tvShowMapper.transform(entity.results),
                entity.total_results,
                entity.page,
                entity.total_pages)
    }
}