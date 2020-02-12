package com.example.mvppattern.ui.listmovies

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.AppConstants.MOVIE_ID
import com.example.mvppattern.R
import com.example.mvppattern.ui.listmovies.adapter.MovieAdapter
import com.example.mvppattern.application.App
import com.example.mvppattern.di.component.DaggerListMoviesComponent
import com.example.mvppattern.di.module.ListMoviesModule
import com.example.mvppattern.ui.baseloading.BaseLoadingViewActivity
import com.example.mvppattern.ui.cardmovie.CardMovieViewActivity
import kotlinx.android.synthetic.main.activity_list_preview_view.*
import javax.inject.Inject

@kotlinx.serialization.UnstableDefault
class ListMoviesViewActivity : BaseLoadingViewActivity(),
    ListMoviesView,
    MovieAdapter.OnItemClickListener {

    @Inject
    lateinit var listMoviesPresenter: ListMoviesPresenter

    @Inject
    lateinit var movieAdapter: MovieAdapter
//    private val movieAdapter = MovieAdapter(this, this)

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

    override fun onItemClicked(moviePreview: com.example.core.dto.MoviePreview) {
        loadMoviesDetailInfo(moviePreview.id)
    }

    override fun showListMoviePreviews(listMovies: List<com.example.core.dto.MoviePreview>) =
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
