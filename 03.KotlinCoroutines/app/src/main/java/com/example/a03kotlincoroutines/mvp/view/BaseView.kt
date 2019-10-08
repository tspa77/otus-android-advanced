package com.example.a03kotlincoroutines.mvp.view

interface BaseView {

    fun showLoading()

    fun hideLoading()

    fun showError(message: String)
}