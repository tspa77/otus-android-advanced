package com.example.mvppattern.mvp.view

import com.example.mvppattern.adapter.MoviePreview

interface ListPreviewView : LoadingView {

    fun showListPreviews(listPreviews: List<MoviePreview>)
}
