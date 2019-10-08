package com.example.a03kotlincoroutines.mvp.presenter

import android.util.Log
import com.example.a03kotlincoroutines.AppConstans.MY_TAG
import com.example.a03kotlincoroutines.mvp.PreviewContract
import com.example.a03kotlincoroutines.network.CoroutineNetworkProvider

class PresenterPreviews(private val view: PreviewContract.ViewList<PresenterPreviews>) :
    PreviewContract.PresenterListPreviews {

    private val networkProvider = CoroutineNetworkProvider

    override fun loadListPreviews() {
        view.showLoading()
        networkProvider.getListPreviews({
            view.hideLoading()
            view.showListPreviews(it)
        }, {
            view.hideLoading()
            Log.d(MY_TAG, it.stackTrace.joinToString("\n"))
            view.showError(it.localizedMessage)
        })
    }
}
