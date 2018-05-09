package com.taidang.themoviedb.presentation.presenter

import com.taidang.themoviedb.domain.model.TvShow
import com.taidang.themoviedb.domain.usecase.GetTvShowsUsecase
import com.taidang.themoviedb.presentation.contract.TopRatedTvShowsContract
import com.taidang.themoviedb.presentation.manager.AppConfigManager
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by thuyhien on 5/7/18.
 */
class TopRatedTvShowPresenter
@Inject constructor(private val getTvShowsUsecase: GetTvShowsUsecase,
                    private val appConfigManager: AppConfigManager)
    : TopRatedTvShowsContract.Presenter {

    private val mDisposable = CompositeDisposable()

    override var mView: TopRatedTvShowsContract.View? = null

    override fun attachView(v: TopRatedTvShowsContract.View) {
        mView = v
    }

    override fun start() {
        val disposable = getTvShowsUsecase.getTopRatedTvShows()
                .doOnSubscribe { mView?.displayLoading() }
                .subscribe(
                        { mView?.displayTvShows(it.tvShows) },
                        { mView?.displayError(it) }
                )
        mDisposable.add(disposable)
    }

    override fun destroy() {
        mView = null
        mDisposable.clear()
    }

    override fun chooseTvShow(tvShow: TvShow) {
        mView?.gotoDetailTvShow(tvShow)
    }
}