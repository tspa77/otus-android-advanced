package com.example.mvppattern.mvp.presenter

import com.example.mvppattern.data.MovieDetails

interface BasePresenter {

    fun getListPreviews(onDone: () -> Unit, onError: (Throwable) -> Unit)

    fun getDetailsInfo(id: Int, onDone: (MovieDetails) -> Unit, onError: (Throwable) -> Unit)
}