package com.example.mvppattern.mvp.view

import com.example.mvppattern.mvp.model.MoviePreview

interface ListPreviewView : LoadingView {

    fun showListPreviews(listPreviews: List<MoviePreview>)
}
