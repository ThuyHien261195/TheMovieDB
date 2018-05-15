package com.taidang.themoviedb.presentation.presenter

import com.taidang.themoviedb.domain.model.TvEpisode
import com.taidang.themoviedb.domain.usecase.GetTvSeasonDetailsUsecase
import com.taidang.themoviedb.presentation.contract.TvSeasonDetailsContract
import com.taidang.themoviedb.presentation.di.DependencyName
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by thuyhien on 5/14/18.
 */
class TvSeasonDetailsPresenter
@Inject constructor(private val tvSeasonDetailsUsecase: GetTvSeasonDetailsUsecase,
                    @Named(DependencyName.DI_TV_SHOW_ID) private val tvShowId: Int,
                    @Named(DependencyName.DI_TV_SEASON_ID) private val tvSeasonId: Int)
    : TvSeasonDetailsContract.Presenter {
    private val disposables = CompositeDisposable()

    override var mView: TvSeasonDetailsContract.View? = null

    override fun attachView(v: TvSeasonDetailsContract.View) {
        mView = v
    }

    override fun start() {
        val disposable = tvSeasonDetailsUsecase.getTvSeasonDetails(tvShowId, tvSeasonId)
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

    override fun chooseTvEpisode(tvEpisode: TvEpisode) {
        mView?.gotoTvEpisode(tvEpisode)
    }
}