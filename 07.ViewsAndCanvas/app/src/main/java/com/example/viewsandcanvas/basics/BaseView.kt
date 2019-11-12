package com.example.viewsandcanvas.basics

interface BaseView {

    fun showLoading()

    fun hideLoading()

    fun showError(message: String)
}