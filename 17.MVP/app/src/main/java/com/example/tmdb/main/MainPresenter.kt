package com.example.tmdb.main

import android.util.Log
import com.example.tmdb.AppConstants.MY_TAG
import com.example.tmdb.basics.PreviewContract
import com.example.tmdb.network.CoroutineNetworkProvider

class MainPresenter(private val viewMain: PreviewContract.ListPreviewsView<MainPresenter>) :
    PreviewContract.ListPreviewsPresenter {

    private val networkProvider = CoroutineNetworkProvider

    @kotlinx.serialization.UnstableDefault
    override fun loadListPreviews() {
        viewMain.showLoading()
        networkProvider.getListPreviews({
            viewMain.hideLoading()
            viewMain.showListPreviews(it)
        }, {
            viewMain.hideLoading()
            Log.d(MY_TAG, it.stackTrace.joinToString("\n"))
            viewMain.showError(it.localizedMessage!!)
        })
    }
}
