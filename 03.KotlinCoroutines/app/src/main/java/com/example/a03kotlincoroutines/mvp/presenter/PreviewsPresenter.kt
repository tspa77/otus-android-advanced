package com.example.a03kotlincoroutines.mvp.presenter

import android.util.Log
import com.example.a03kotlincoroutines.AppConstants.MY_TAG
import com.example.a03kotlincoroutines.mvp.PreviewContract
import com.example.a03kotlincoroutines.network.CoroutineNetworkProvider

class PreviewsPresenter(private val viewPreviews: PreviewContract.ListPreviewsView<PreviewsPresenter>) :
    PreviewContract.ListPreviewsPresenter {

    private val networkProvider = CoroutineNetworkProvider

    override fun loadListPreviews() {
        viewPreviews.showLoading()
        networkProvider.getListPreviews({
            viewPreviews.hideLoading()
            viewPreviews.showListPreviews(it)
        }, {
            viewPreviews.hideLoading()
            Log.d(MY_TAG, it.stackTrace.joinToString("\n"))
            viewPreviews.showError(it.localizedMessage)
        })
    }
}
