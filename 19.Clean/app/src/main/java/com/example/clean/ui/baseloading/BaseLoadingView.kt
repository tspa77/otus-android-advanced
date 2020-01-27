package com.example.clean.ui.baseloading

interface BaseLoadingView {

    fun showLoading()

    fun hideLoading()

    fun showError(message: String)
}
