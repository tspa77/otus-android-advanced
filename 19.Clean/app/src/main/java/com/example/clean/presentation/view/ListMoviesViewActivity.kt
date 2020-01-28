package com.example.clean.presentation.view

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clean.R
import com.example.clean.application.App
import com.example.clean.di.component.DaggerListMoviesComponent
import com.example.clean.di.module.ListMoviesModule
import com.example.clean.domain.AppConstants.MOVIE_ID
import com.example.clean.domain.dto.MoviePreview
import com.example.clean.presentation.presenter.ListMoviesPresenter
import com.example.clean.presentation.view.adapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_list_preview_view.*
import kotlinx.serialization.UnstableDefault
import javax.inject.Inject


@UnstableDefault
class ListMoviesViewActivity : BaseLoadingViewActivity(),
    ListMoviesView,
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
