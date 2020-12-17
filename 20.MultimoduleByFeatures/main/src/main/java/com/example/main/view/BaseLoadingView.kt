package com.example.main.view

interface BaseLoadingView {

    fun showLoading()

    fun hideLoading()

    fun showError(message: String)
}
