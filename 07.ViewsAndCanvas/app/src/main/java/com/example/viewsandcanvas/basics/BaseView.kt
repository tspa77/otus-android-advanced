package com.example.a03kotlincoroutines.basics

interface BaseView {

    fun showLoading()

    fun hideLoading()

    fun showError(message: String)
}