package com.example.viewsandcanvas.basics

import com.example.viewsandcanvas.model.MoviePreview

interface PreviewContract {

    interface ListPreviewsView<PresenterListPreviews> :
        BaseView {
        fun showListPreviews(listPreviews: List<MoviePreview>)
    }

    interface ListPreviewsPresenter : BasePresenter {
        fun loadListPreviews()
    }
}
