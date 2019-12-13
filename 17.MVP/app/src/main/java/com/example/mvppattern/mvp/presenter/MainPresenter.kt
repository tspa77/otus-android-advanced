package com.example.mvppattern.mvp.presenter

import android.util.Log
import com.example.mvppattern.AppConstants.MY_LOG_TAG
import com.example.mvppattern.contracts.PreviewContract
import com.example.mvppattern.mvp.model.Repository

class MainPresenter(private val viewMain: PreviewContract.ListPreviewsView<MainPresenter>) :
    PreviewContract.ListPreviewsPresenter {

    private val repository = Repository

    @kotlinx.serialization.UnstableDefault
    override fun loadListPreviews() {
        viewMain.showLoading()
        repository.getListPreviews({
            viewMain.hideLoading()
            viewMain.showListPreviews(it)
            Log.d(MY_LOG_TAG, "MainPresenter\n" + it.joinToString("\n"))
        }, {
            viewMain.hideLoading()
            viewMain.showError(it.localizedMessage!!)
            Log.d(MY_LOG_TAG, "MainPresenter\n" + it.stackTrace.joinToString("\n"))
        })
    }
}
