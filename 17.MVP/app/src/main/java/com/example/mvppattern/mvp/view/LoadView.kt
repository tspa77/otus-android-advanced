package com.example.mvppattern.mvp.view

interface LoadView {

    fun showLoading()

    fun hideLoading()

    fun showError(message: String)
}