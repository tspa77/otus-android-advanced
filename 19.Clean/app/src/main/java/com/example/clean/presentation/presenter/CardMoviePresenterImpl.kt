package com.example.clean.presentation.presenter

import android.util.Log
import com.example.clean.domain.repo.Repository
import com.example.clean.AppConstants.TMDB_LOG_TAG
import com.example.clean.presentation.view.CardMovieView


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
