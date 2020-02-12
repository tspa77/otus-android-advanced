package com.example.card_moview.presenter

import android.util.Log
import com.example.card_moview.view.CardMovieView
import com.example.core.AppConstants.TMDB_LOG_TAG
import com.example.network.repository.Repository

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
