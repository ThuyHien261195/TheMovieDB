package com.taidang.themoviedb.repository

import com.taidang.themoviedb.domain.TvShowRepository
import com.taidang.themoviedb.domain.model.MoviesInfo
import com.taidang.themoviedb.domain.model.TvShow
import com.taidang.themoviedb.domain.model.TvShowsInfo
import com.taidang.themoviedb.repository.http.TvShowHttpClient
import com.taidang.themoviedb.repository.mapper.MoviesInfoMapper
import com.taidang.themoviedb.repository.mapper.TvShowMapper
import com.taidang.themoviedb.repository.mapper.TvShowsInfoMapper
import io.reactivex.Single

/**
 * Created by thuyhien on 5/7/18.
 */
class TvShowRemoteDataStore(
        private val tvShowHttpClient: TvShowHttpClient,
        private val tvShowsInfoMapper: TvShowsInfoMapper,
        private val tvShowMapper: TvShowMapper) : TvShowRepository {
    override fun getPopularTvShows(language: String, page: Int): Single<TvShowsInfo> {
        return tvShowHttpClient.getPopularTvShows(language, page)
                .map { tvShowsInfoMapper.transform(it) }
    }

    override fun getTopRatedTvShows(language: String, page: Int): Single<TvShowsInfo> {
        return tvShowHttpClient.getTopRatedTvShows(language, page)
                .map { tvShowsInfoMapper.transform(it) }
    }

    override fun getTvShowDetails(id: Int): Single<TvShow> {
        return tvShowHttpClient.getTvShowDetails(id, "en-US", "credits,videos,keywords,content_ratings")
                .map { tvShowMapper.transform(it) }
    }
}