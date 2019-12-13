package com.example.mvppattern.mvp.view

interface BaseView {

    fun showLoading()

    fun hideLoading()

    fun showError(message: String)
}