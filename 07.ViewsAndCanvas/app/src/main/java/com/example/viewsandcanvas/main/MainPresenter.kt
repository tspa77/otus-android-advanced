package com.example.a03kotlincoroutines.main

import android.util.Log
import com.example.a03kotlincoroutines.AppConstants.MY_TAG
import com.example.a03kotlincoroutines.basics.PreviewContract
import com.example.a03kotlincoroutines.network.CoroutineNetworkProvider

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
