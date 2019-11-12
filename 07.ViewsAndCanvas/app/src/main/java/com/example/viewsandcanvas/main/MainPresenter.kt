package com.example.viewsandcanvas.main

import android.util.Log
import com.example.viewsandcanvas.AppConstants.MY_TAG
import com.example.viewsandcanvas.basics.PreviewContract
import com.example.viewsandcanvas.network.CoroutineNetworkProvider

class MainPresenter(private val viewMain: PreviewContract.ListPreviewsView<MainPresenter>) :
    PreviewContract.ListPreviewsPresenter {

    private val networkProvider = CoroutineNetworkProvider

    override fun loadListPreviews() {
        viewMain.showLoading()
        networkProvider.getListPreviews({
            viewMain.hideLoading()
            viewMain.showListPreviews(it)
        }, {
            viewMain.hideLoading()
            Log.d(MY_TAG, it.stackTrace.joinToString("\n"))
            viewMain.showError(it.localizedMessage)
        })
    }
}
