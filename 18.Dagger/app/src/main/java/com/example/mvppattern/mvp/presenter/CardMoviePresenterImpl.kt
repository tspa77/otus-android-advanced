package com.example.mvppattern.mvp.presenter

import android.util.Log
import com.example.mvppattern.AppConstants.TMDB_LOG_TAG
import com.example.mvppattern.mvp.model.Repository
import com.example.mvppattern.mvp.view.CardMovieView
import kotlinx.serialization.UnstableDefault

@UnstableDefault
class CardMoviePresenterImpl(
    private val view: CardMovieView,
    private val repository: Repository
) : CardMoviePresenter {

    override fun getMovieInfo(id: Int) {
        view.showLoading()
        repository.getMovieInfo(id, {
            view.hideLoading()
            view.showMovieInfo(it)
            Log.d(TMDB_LOG_TAG, it.toString())
        }, {
            view.hideLoading()
            view.showError(it.localizedMessage!!)
            Log.d(TMDB_LOG_TAG, it.stackTrace.joinToString("\n"))
        })
    }
}
