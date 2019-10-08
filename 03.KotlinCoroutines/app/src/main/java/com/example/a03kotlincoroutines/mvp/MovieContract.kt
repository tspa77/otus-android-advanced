package com.example.a03kotlincoroutines.mvp

import com.example.a03kotlincoroutines.mvp.model.MovieFullInfo
import com.example.a03kotlincoroutines.mvp.model.MoviePreview
import com.example.a03kotlincoroutines.mvp.presenter.PresenterBase
import com.example.a03kotlincoroutines.mvp.view.BaseView

interface MovieContract {
    interface ViewList : BaseView<PresenterListPreviews> {
        fun updateListMovies(loadMoviePreviews: List<MoviePreview>)
    }

    interface ViewInfo : BaseView<PresenterFullInfo> {
        fun showMovieInfo(movieInfo: MovieFullInfo)
    }

    interface PresenterListPreviews : PresenterBase {
        fun loadListPreviews()
    }

    interface PresenterFullInfo : PresenterBase {
        fun loadFullInfo(id: Int)
    }
}
