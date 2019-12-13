package com.example.mvppattern.basics

interface BaseView {

    fun showLoading()

    fun hideLoading()

    fun showError(message: String)
}