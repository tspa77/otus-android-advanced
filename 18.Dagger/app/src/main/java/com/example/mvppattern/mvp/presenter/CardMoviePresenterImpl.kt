package com.example.mvppattern.mvp.presenter

import android.util.Log
import com.example.mvppattern.AppConstants.MY_LOG_TAG
import com.example.mvppattern.mvp.model.Repository
import com.example.mvppattern.mvp.view.CardMovieView

@kotlinx.serialization.UnstableDefault
class CardMoviePresenterImpl(
    private val view: CardMovieView,
    private val repository: Repository
) : CardMoviePresenter {

    override fun getMovieInfo(id: Int) {
        view.showLoading()
        repository.getDetailsInfo(id, {
            view.hideLoading()
            view.showMovieInfo(it)
            Log.d(MY_LOG_TAG, it.toString())
        }, {
            view.hideLoading()
            view.showError(it.localizedMessage!!)
            Log.d(MY_LOG_TAG, it.stackTrace.joinToString("\n"))
        })
    }
}
