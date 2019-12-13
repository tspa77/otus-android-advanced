package com.example.mvppattern.mvp.view

import com.example.mvppattern.data.MoviePreview

interface MainView {
    fun showListPreviews(listPreviews: List<MoviePreview>)
}