package com.example.a03kotlincoroutines.mvp.presenter

import android.util.Log
import com.example.a03kotlincoroutines.mvp.MovieContract
import com.example.a03kotlincoroutines.network.CoroutineNetworkProvider

class PresenterPreviews(private val view: MovieContract.ViewList) :
    MovieContract.PresenterListPreviews {

    private val networkProvider = CoroutineNetworkProvider

    override fun loadListPreviews() {
        view.showLoading()
        networkProvider.getListMovies({
            view.hideLoading()
            view.updateListMovies(it)
        }, {
            view.hideLoading()
            Log.d("!!!", it.stackTrace.joinToString("\n"))
            view.showError(it.localizedMessage)
        })
    }
}
