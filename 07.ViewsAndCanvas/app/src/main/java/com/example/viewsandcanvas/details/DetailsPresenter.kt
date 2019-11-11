package com.example.a03kotlincoroutines.details

import android.util.Log
import com.example.a03kotlincoroutines.AppConstants.MY_TAG
import com.example.a03kotlincoroutines.basics.DetailsContract
import com.example.a03kotlincoroutines.network.CoroutineNetworkProvider

class DetailsPresenter(private val view: DetailsContract.BaseViewInfo<DetailsPresenter>) :
    DetailsContract.DetailsPresenter {

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
