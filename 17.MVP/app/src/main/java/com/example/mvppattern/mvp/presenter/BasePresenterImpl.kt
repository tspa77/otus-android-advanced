package com.example.mvppattern.mvp.presenter

import android.util.Log
import com.example.mvppattern.AppConstants.MY_LOG_TAG
import com.example.mvppattern.mvp.model.BaseRepositoryImpl
import com.example.mvppattern.mvp.view.ShowingView

@kotlinx.serialization.UnstableDefault
class BasePresenterImpl(private val view: ShowingView) : BasePresenter {

    private val repository = BaseRepositoryImpl

    override fun loadInfo(id: Int) {
        view.showLoading()
        repository.getDetailsInfo(id, {
            view.hideLoading()
            view.showDetailsInfo(it)
            Log.d(MY_LOG_TAG, it.toString())
        }, {
            view.hideLoading()
            view.showError(it.localizedMessage!!)
            Log.d(MY_LOG_TAG, it.stackTrace.joinToString("\n"))
        })
    }
}
