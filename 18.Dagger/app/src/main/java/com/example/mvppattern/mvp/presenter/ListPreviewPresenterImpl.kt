package com.example.mvppattern.mvp.presenter

import android.util.Log
import com.example.mvppattern.application.AppConstants.MY_LOG_TAG
import com.example.mvppattern.mvp.model.Repository
import com.example.mvppattern.mvp.model.RepositoryImpl
import com.example.mvppattern.mvp.view.ListPreviewView

@kotlinx.serialization.UnstableDefault
class ListPreviewPresenterImpl(
    private val view: ListPreviewView,
    private val repository: Repository) : ListPreviewPresenter {

    override fun getListPreviews() {
        view.showLoading()
        repository.getListPreviews({
            view.hideLoading()
            view.showListPreviews(it)
            Log.d(MY_LOG_TAG, it.toString())
        }, {
            view.hideLoading()
            view.showError(it.localizedMessage!!)
            Log.d(MY_LOG_TAG, it.stackTrace.joinToString("\n"))
        })
    }
}
