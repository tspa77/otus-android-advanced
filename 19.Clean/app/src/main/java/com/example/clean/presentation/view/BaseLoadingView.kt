package com.example.clean.presentation.view


interface BaseLoadingView {

    fun showLoading()

    fun hideLoading()

    fun showError(message: String)
}
