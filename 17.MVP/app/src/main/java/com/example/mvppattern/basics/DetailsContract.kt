package com.example.mvppattern.basics

import com.example.mvppattern.model.MovieDetails

interface DetailsContract {

    interface BaseViewInfo<PresenterDetails> : BaseView {
        fun showDetailsInfo(movieInfo: MovieDetails)
    }

    interface DetailsPresenter : BasePresenter {
        fun loadDetailsInfo(id: Int)
    }
}
