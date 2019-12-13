package com.example.tmdb.basics

import com.example.tmdb.model.MovieDetails

interface DetailsContract {

    interface BaseViewInfo<PresenterDetails> : BaseView {
        fun showDetailsInfo(movieInfo: MovieDetails)
    }

    interface DetailsPresenter : BasePresenter {
        fun loadDetailsInfo(id: Int)
    }
}
