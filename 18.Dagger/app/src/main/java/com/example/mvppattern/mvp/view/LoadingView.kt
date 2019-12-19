package com.example.mvppattern.mvp.view

interface LoadingView {

    fun showLoading()

    fun hideLoading()

    fun showError(message: String)
}
