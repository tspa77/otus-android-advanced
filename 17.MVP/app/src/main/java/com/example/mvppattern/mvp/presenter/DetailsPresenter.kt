package com.example.mvppattern.mvp.presenter

import android.util.Log
import com.example.mvppattern.AppConstants.MY_LOG_TAG
import com.example.mvppattern.contracts.DetailsContract
import com.example.mvppattern.mvp.model.Repository
import kotlinx.serialization.UnstableDefault

@UnstableDefault
class DetailsPresenter(private val view: DetailsContract.BaseViewInfo<DetailsPresenter>) :
    DetailsContract.DetailsPresenter {

    private val repository = Repository

    override fun loadDetailsInfo(id: Int) {
        view.showLoading()
        repository.getDetailsInfo(id, {
            view.hideLoading()
            view.showDetailsInfo(it)
            Log.d(MY_LOG_TAG, it.toString())
        }, {
            view.hideLoading()
            Log.d(MY_LOG_TAG, it.stackTrace.joinToString("\n"))
            view.showError(it.localizedMessage!!)
        })
    }
}
