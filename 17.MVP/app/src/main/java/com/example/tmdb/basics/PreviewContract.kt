package com.example.tmdb.basics

import com.example.tmdb.model.MoviePreview

interface PreviewContract {

    interface ListPreviewsView<PresenterListPreviews> :
        BaseView {
        fun showListPreviews(listPreviews: List<MoviePreview>)
    }

    interface ListPreviewsPresenter : BasePresenter {
        fun loadListPreviews()
    }
}
