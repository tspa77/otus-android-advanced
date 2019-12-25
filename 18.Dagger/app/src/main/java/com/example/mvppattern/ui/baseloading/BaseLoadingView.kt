package com.example.mvppattern.ui.baseloading

interface BaseLoadingView {

    fun showLoading()

    fun hideLoading()

    fun showError(message: String)
}
