package com.example.tmdb.main

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb.AppConstants.MOVIE_ID
import com.example.tmdb.R
import com.example.tmdb.adapter.MovieAdapter
import com.example.tmdb.basics.LoadActivity
import com.example.tmdb.basics.PreviewContract
import com.example.tmdb.details.DetailsActivity
import com.example.tmdb.model.MoviePreview
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : LoadActivity(),
    PreviewContract.ListPreviewsView<MainPresenter>, MovieAdapter.OnItemClickListener {

    private lateinit var presenterMain: MainPresenter
    private val movieAdapter = MovieAdapter(this, this)

    override val progressBar: ProgressBar
        get() = findViewById(R.id.progress_bar)

    @kotlinx.serialization.UnstableDefault
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movies.adapter = movieAdapter
        rv_movies.layoutManager = LinearLayoutManager(this)

        presenterMain = MainPresenter(this)
        presenterMain.loadListPreviews()
    }

    override fun onItemClicked(moviePreview: MoviePreview) {
        loadMoviesDetailInfo(moviePreview.id)
    }

    private fun loadMoviesDetailInfo(id: Int) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(MOVIE_ID, id)
        startActivity(intent)
    }

    override fun showListPreviews(listPreviews: List<MoviePreview>) =
        movieAdapter.setData(listPreviews)
}
