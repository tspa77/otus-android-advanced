package com.example.a03kotlincoroutines.mvp.presenter

import android.util.Log
import com.example.a03kotlincoroutines.AppConstans.MY_TAG
import com.example.a03kotlincoroutines.mvp.DetailsContract
import com.example.a03kotlincoroutines.network.CoroutineNetworkProvider

class PresenterDetails(private val view: DetailsContract.ViewInfo<PresenterDetails>) :
    DetailsContract.PresenterDetails {

    private val networkProvider = CoroutineNetworkProvider

    override fun loadDetailsInfo(id: Int) {
        view.showLoading()
        networkProvider.getDetailsInfo(id, {
            view.hideLoading()
            view.showDetailsInfo(it)
        }, {
            view.hideLoading()
            Log.d(MY_TAG, it.stackTrace.joinToString("\n"))
            view.showError(it.localizedMessage)
        })
    }
}
