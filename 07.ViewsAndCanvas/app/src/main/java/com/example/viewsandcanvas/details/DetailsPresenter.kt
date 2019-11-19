package com.example.viewsandcanvas.details

import android.util.Log
import com.example.viewsandcanvas.AppConstants.MY_TAG
import com.example.viewsandcanvas.basics.DetailsContract
import com.example.viewsandcanvas.network.CoroutineNetworkProvider

class DetailsPresenter(private val view: DetailsContract.BaseViewInfo<DetailsPresenter>) :
    DetailsContract.DetailsPresenter {

    private val networkProvider = CoroutineNetworkProvider

    @kotlinx.serialization.UnstableDefault
    override fun loadDetailsInfo(id: Int) {
        view.showLoading()
        networkProvider.getDetailsInfo(id, {
            view.hideLoading()
            view.showDetailsInfo(it)
        }, {
            view.hideLoading()
            Log.d(MY_TAG, it.stackTrace.joinToString("\n"))
            view.showError(it.localizedMessage!!)
        })
    }
}
