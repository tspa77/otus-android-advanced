package com.example.mvppattern.mvp.presenter

import android.util.Log
import com.example.mvppattern.AppConstants.MY_LOG_TAG
import com.example.mvppattern.mvp.model.RepositoryImpl
import com.example.mvppattern.mvp.view.DetailsView

@kotlinx.serialization.UnstableDefault
class DetailsPresenterImpl(private val view: DetailsView) : DetailsPresenter {

    private val repository = RepositoryImpl

    override fun getInfo(id: Int) {
        view.showLoading()
        repository.getDetailsInfo(id, {
            view.hideLoading()
            view.showDetailsInfo(it)
            Log.d(MY_LOG_TAG, it.toString())
        }, {
            view.hideLoading()
            view.showError(it.localizedMessage!!)
            Log.d(MY_LOG_TAG, it.stackTrace.joinToString("\n"))
        })
    }
}
