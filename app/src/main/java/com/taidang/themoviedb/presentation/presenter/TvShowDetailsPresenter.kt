package com.taidang.themoviedb.presentation.presenter

import com.taidang.themoviedb.domain.model.TvSeason
import com.taidang.themoviedb.domain.usecase.GetTvShowDetailsUsecase
import com.taidang.themoviedb.presentation.contract.TvShowDetailsContract
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by thuyhien on 5/10/18.
 */
class TvShowDetailsPresenter
@Inject constructor(private val getTvShowDetailsUsecase: GetTvShowDetailsUsecase, private val tvShowId: Int)
    : TvShowDetailsContract.Presenter {
    private val disposables = CompositeDisposable()

    override var mView: TvShowDetailsContract.View? = null

    override fun attachView(v: TvShowDetailsContract.View) {
        mView = v
    }

    override fun start() {
        val disposable = getTvShowDetailsUsecase.getSeriesDetails(tvShowId)
                .doOnSubscribe { mView?.displayLoading() }
                .subscribe(
                        {
                            mView?.run {
                                hideLoading()
                                showDetails(it)
                            }
                        },
                        {
                            mView?.run {
                                hideLoading()
                                displayError(it)
                            }
                        }
                )
        disposables.add(disposable)
    }

    override fun destroy() {
        mView = null
        disposables.clear()
    }

    override fun chooseSeason(tvSeason: TvSeason) {
        mView?.goToTvShow(tvSeason)
    }
}