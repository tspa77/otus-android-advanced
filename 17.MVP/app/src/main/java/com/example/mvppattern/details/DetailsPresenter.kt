package com.example.mvppattern.details

import android.util.Log
import com.example.mvppattern.AppConstants.MY_LOG_TAG
import com.example.mvppattern.basics.DetailsContract
import com.example.mvppattern.network.CoroutineNetworkProvider

class DetailsPresenter(private val view: DetailsContract.BaseViewInfo<DetailsPresenter>) :
    DetailsContract.DetailsPresenter {

    private val networkProvider = CoroutineNetworkProvider

    @kotlinx.serialization.UnstableDefault
    override fun loadDetailsInfo(id: Int) {
        view.showLoading()
        networkProvider.getDetailsInfo(id, {
            view.hideLoading()
            view.showDetailsInfo(it)
            Log.d(MY_LOG_TAG, it.toString())
        }, {
            view.hideLoading()
            Log.d(MY_LOG_TAG, it.stackTrace.joinToString("\n"))
            view.showError(it.localizedMessage!!)
        })
    }
}
