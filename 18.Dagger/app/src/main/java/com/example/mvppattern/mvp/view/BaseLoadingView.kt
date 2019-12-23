package com.example.mvppattern.mvp.view

interface BaseLoadingView {

    fun showLoading()

    fun hideLoading()

    fun showError(message: String)
}
