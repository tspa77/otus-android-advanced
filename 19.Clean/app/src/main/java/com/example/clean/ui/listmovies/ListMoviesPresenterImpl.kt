package com.example.clean.ui.listmovies

import android.util.Log
import com.example.clean.common.AppConstants.TMDB_LOG_TAG
import com.example.clean.model.Repository
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
