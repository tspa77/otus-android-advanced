package com.example.viewsandcanvas.main

import android.util.Log
import com.example.viewsandcanvas.AppConstants.MY_LOG_TAG
import com.example.viewsandcanvas.basics.PreviewContract
import com.example.viewsandcanvas.network.CoroutineNetworkProvider

class MainPresenter(private val viewMain: PreviewContract.ListPreviewsView<MainPresenter>) :
    PreviewContract.ListPreviewsPresenter {

    private val networkProvider = CoroutineNetworkProvider

    @kotlinx.serialization.UnstableDefault
    override fun loadListPreviews() {
        viewMain.showLoading()
        networkProvider.getListPreviews({
            viewMain.hideLoading()
            viewMain.showListPreviews(it)
            Log.d(MY_LOG_TAG, it.joinToString("\n"))
        }, {
            viewMain.hideLoading()
            Log.d(MY_LOG_TAG, it.stackTrace.joinToString("\n"))
            viewMain.showError(it.localizedMessage!!)
        })
    }
}
