package com.example.tmdb.basics

interface BaseView {

    fun showLoading()

    fun hideLoading()

    fun showError(message: String)
}