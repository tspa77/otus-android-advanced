package com.example.mvppattern.mvp.view

import com.example.mvppattern.data.MoviePreview

interface MainView : LoadingView {
    fun showListPreviews(listPreviews: List<MoviePreview>)
}
