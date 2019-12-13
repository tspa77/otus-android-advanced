package com.example.mvppattern.mvp.presenter

import android.util.Log
import com.example.mvppattern.AppConstants.MY_LOG_TAG
import com.example.mvppattern.contracts.PreviewContract
import com.example.mvppattern.mvp.model.BaseRepositoryImpl

class MainPresenterImpl(private val viewMainImpl: PreviewContract.ListPreviewsView<MainPresenterImpl>) :
    PreviewContract.ListPreviewsPresenter {

    private val repository = BaseRepositoryImpl

    @kotlinx.serialization.UnstableDefault
    override fun loadListPreviews() {
        viewMainImpl.showLoading()
        repository.getListPreviews({
            viewMainImpl.hideLoading()
            viewMainImpl.showListPreviews(it)
            Log.d(MY_LOG_TAG, "MainPresenter\n" + it.joinToString("\n"))
        }, {
            viewMainImpl.hideLoading()
            viewMainImpl.showError(it.localizedMessage!!)
            Log.d(MY_LOG_TAG, "MainPresenter\n" + it.stackTrace.joinToString("\n"))
        })
    }
}
