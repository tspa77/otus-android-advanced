package com.example.viewsandcanvas.basics

import com.example.viewsandcanvas.model.MovieDetails

interface DetailsContract {

    interface BaseViewInfo<PresenterDetails> : BaseView {
        fun showDetailsInfo(movieInfo: MovieDetails)
    }

    interface DetailsPresenter : BasePresenter {
        fun loadDetailsInfo(id: Int)
    }
}
