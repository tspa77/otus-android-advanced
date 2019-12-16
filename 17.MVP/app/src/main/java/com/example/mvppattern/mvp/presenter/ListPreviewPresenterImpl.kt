package com.example.mvppattern.mvp.presenter

import android.util.Log
import com.example.mvppattern.AppConstants
import com.example.mvppattern.mvp.model.RepositoryImpl
import com.example.mvppattern.mvp.view.ListPreviewView

@kotlinx.serialization.UnstableDefault
class ListPreviewPresenterImpl(private val view: ListPreviewView) : ListPreviewPresenter {

    private val repository = RepositoryImpl

    override fun getListPreviews() {
        view.showLoading()
        repository.getListPreviews({
            view.hideLoading()
            view.showListPreviews(it)
            Log.d(AppConstants.MY_LOG_TAG, it.toString())
        }, {
            view.hideLoading()
            view.showError(it.localizedMessage!!)
            Log.d(AppConstants.MY_LOG_TAG, it.stackTrace.joinToString("\n"))
        })
    }
}
