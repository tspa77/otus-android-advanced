package com.example.list_movies.view

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.card_moview.view.CardMovieViewActivity
import com.example.core.AppConstants.MOVIE_ID
import com.example.core.dto.MoviePreview
import com.example.list_movies.R
import com.example.list_movies.adapter.MovieAdapter
import com.example.list_movies.di.DaggerListMoviesComponent
import com.example.list_movies.di.ListMoviesModule
import com.example.list_movies.presenter.ListMoviesPresenter
import com.example.main.App
import com.example.main.view.BaseLoadingViewActivity
import kotlinx.android.synthetic.main.activity_list_preview_view.*
import javax.inject.Inject

@kotlinx.serialization.UnstableDefault
class ListMoviesViewActivity : BaseLoadingViewActivity(), ListMoviesView,
    MovieAdapter.OnItemClickListener {

    @Inject
    lateinit var listMoviesPresenter: ListMoviesPresenter

    @Inject
    lateinit var movieAdapter: MovieAdapter

    override val progressBar: ProgressBar
        get() = findViewById(R.id.progress_bar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_preview_view)
        daggerInject()

        rv_movies.adapter = movieAdapter
        rv_movies.layoutManager = LinearLayoutManager(this)

        listMoviesPresenter.getListMoviePreviews()
    }

    override fun onItemClicked(moviePreview: MoviePreview) {
        loadMoviesDetailInfo(moviePreview.id)
    }

    override fun showListMoviePreviews(listMovies: List<MoviePreview>) =
        movieAdapter.setData(listMovies)

    private fun daggerInject() {
        val appComponent = (application as App).getComponent()
        DaggerListMoviesComponent.builder()
            .appComponent(appComponent)
            .listMoviesModule(ListMoviesModule(this))
            .build()
            .inject(this)
    }

    private fun loadMoviesDetailInfo(id: Int) {
        val intent = Intent(this, CardMovieViewActivity::class.java)
        intent.putExtra(MOVIE_ID, id)
        startActivity(intent)
    }
}
