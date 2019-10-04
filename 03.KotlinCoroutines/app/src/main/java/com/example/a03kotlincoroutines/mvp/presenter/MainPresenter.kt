package com.example.a03kotlincoroutines.mvp.presenter

import com.example.a03kotlincoroutines.mvp.MovieContract
import com.example.a03kotlincoroutines.network.CoroutineNetworkProvider

class MainPresenter(private val view: MovieContract.View) : MovieContract.Presenter {

    private val networkProvider = CoroutineNetworkProvider

    override fun loadListMovies() {
        view.showLoading()
        networkProvider.getListMovies({
            view.hideLoading()
            view.setupRecyclerView(it)
        }, {
            view.hideLoading()
            view.showError(it.localizedMessage)
        })
    }


    override fun loadMovie() {
        TODO("not implemented")
    }


}