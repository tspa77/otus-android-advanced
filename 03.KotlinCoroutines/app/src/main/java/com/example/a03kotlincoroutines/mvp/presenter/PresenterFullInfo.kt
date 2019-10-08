package com.example.a03kotlincoroutines.mvp.presenter

import android.util.Log
import com.example.a03kotlincoroutines.mvp.MovieContract
import com.example.a03kotlincoroutines.network.CoroutineNetworkProvider

class PresenterFullInfo(private val view: MovieContract.ViewInfo) :
    MovieContract.PresenterFullInfo {

    private val networkProvider = CoroutineNetworkProvider

    override fun loadFullInfo(id: Int) {
        view.showLoading()
        networkProvider.getDetailMovie(id, {
            view.hideLoading()
            view.showMovieInfo(it)
        }, {
            view.hideLoading()
            Log.d("!!!", it.stackTrace.joinToString("\n"))
            view.showError(it.localizedMessage)
        })
    }
}
