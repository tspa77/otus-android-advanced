package com.example.a03kotlincoroutines.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a03kotlincoroutines.AppConstants.MOVIE_ID
import com.example.a03kotlincoroutines.R
import com.example.a03kotlincoroutines.data.MovieAdapter
import com.example.a03kotlincoroutines.mvp.PreviewContract
import com.example.a03kotlincoroutines.mvp.model.MoviePreview
import com.example.a03kotlincoroutines.mvp.presenter.PreviewsPresenter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : LoadActivity(),
    PreviewContract.ListPreviewsView<PreviewsPresenter>, MovieAdapter.OnItemClickListener {

    private lateinit var presenterPreviews: PreviewsPresenter
    private val movieAdapter = MovieAdapter(this, this)

    override val progressBar: ProgressBar
        get() = findViewById(R.id.progressBar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies.adapter = movieAdapter
        rvMovies.layoutManager = LinearLayoutManager(this)

        presenterPreviews = PreviewsPresenter(this)
        presenterPreviews.loadListPreviews()
    }

    override fun onItemClicked(moviePreview: MoviePreview) {
        loadMoviesDetailInfo(moviePreview.id)
    }

    private fun loadMoviesDetailInfo(id: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(MOVIE_ID, id)
        startActivity(intent)
    }

    override fun showListPreviews(listPreviews: List<MoviePreview>) =
        movieAdapter.setData(listPreviews)
}
