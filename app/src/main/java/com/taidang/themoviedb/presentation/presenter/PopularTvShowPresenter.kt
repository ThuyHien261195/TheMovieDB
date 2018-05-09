package com.taidang.themoviedb.presentation.presenter

import android.util.Log
import com.taidang.themoviedb.domain.model.TvShow
import com.taidang.themoviedb.domain.usecase.GetTvShowsUsecase
import com.taidang.themoviedb.presentation.contract.PopularTvShowsContract
import com.taidang.themoviedb.presentation.manager.AppConfigManager
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by thuyhien on 5/7/18.
 */
class PopularTvShowPresenter
@Inject constructor(private val getTvShowsUsecase: GetTvShowsUsecase,
                    private val appConfigManager: AppConfigManager)
    : PopularTvShowsContract.Presenter {

    private val mDisposables = CompositeDisposable()

    override var mView: PopularTvShowsContract.View? = null

    override fun attachView(v: PopularTvShowsContract.View) {
        mView = v
    }

    override fun start() {
        val disposable = getTvShowsUsecase.getPopularTvShows()
                .doOnSubscribe { mView?.displayLoading() }
                .subscribe(
                        {
                            for(item in it.tvShows) {
                                Log.e("Data", item.toString())
                            }
                            mView?.displayTvShows(it.tvShows)
                        },
                        { mView?.displayError(it)}
                )
        mDisposables.add(disposable)
    }

    override fun destroy() {
        mView = null
        mDisposables.clear()
    }

    override fun chooseTvShow(tvShow: TvShow) {
        mView?.gotoDetailTvShow(tvShow)
    }
}