package com.example.mvppattern.mvp.view

import com.example.mvppattern.data.MovieDetails

interface ShowingView {

    fun showLoading()

    fun hideLoading()

    fun showError(message: String)

    fun showDetailsInfo(movieInfo: MovieDetails)
}
