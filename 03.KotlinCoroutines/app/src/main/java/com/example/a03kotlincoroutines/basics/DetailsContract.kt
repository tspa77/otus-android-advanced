package com.example.a03kotlincoroutines.basics

import com.example.a03kotlincoroutines.model.MovieDetails

interface DetailsContract {

    interface BaseViewInfo<PresenterDetails> : BaseView {
        fun showDetailsInfo(movieInfo: MovieDetails)
    }

    interface DetailsPresenter : BasePresenter {
        fun loadDetailsInfo(id: Int)
    }
}
