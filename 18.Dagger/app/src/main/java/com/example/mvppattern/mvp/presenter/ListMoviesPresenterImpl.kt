package com.example.mvppattern.mvp.presenter

import android.util.Log
import com.example.mvppattern.AppConstants.MY_LOG_TAG
import com.example.mvppattern.mvp.model.Repository
import com.example.mvppattern.mvp.view.ListMoviesView

@kotlinx.serialization.UnstableDefault
class ListMoviesPresenterImpl (
    private val view: ListMoviesView,
    private val repository: Repository
) : ListMoviesPresenter {

    override fun getListMovies() {
        view.showLoading()
        repository.getListPreviews({
            view.hideLoading()
            view.showListMovies(it)
            Log.d(MY_LOG_TAG, it.toString())
        }, {
            view.hideLoading()
            view.showError(it.localizedMessage!!)
            Log.d(MY_LOG_TAG, it.stackTrace.joinToString("\n"))
        })
    }
}
