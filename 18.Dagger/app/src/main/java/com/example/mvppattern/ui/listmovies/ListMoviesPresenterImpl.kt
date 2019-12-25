package com.example.mvppattern.ui.listmovies

import android.util.Log
import com.example.mvppattern.common.AppConstants.TMDB_LOG_TAG
import com.example.mvppattern.model.Repository
import kotlinx.serialization.UnstableDefault

@UnstableDefault
class ListMoviesPresenterImpl(
    private val view: ListMoviesView,
    private val repository: Repository
) : ListMoviesPresenter {

    override fun getListMoviePreviews() {
        view.showLoading()
        repository.getListMoviePreviews({
            view.hideLoading()
            view.showListMoviePreviews(it)
            Log.d(TMDB_LOG_TAG, it.toString())
        }, {
            view.hideLoading()
            view.showError(it.localizedMessage!!)
            Log.d(TMDB_LOG_TAG, it.stackTrace.joinToString("\n"))
        })
    }
}
