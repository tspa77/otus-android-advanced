package com.example.viewsandcanvas.main

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewsandcanvas.AppConstants.MOVIE_ID
import com.example.viewsandcanvas.basics.LoadActivity
import com.example.a03kotlincoroutines.R
import com.example.viewsandcanvas.adapter.MovieAdapter
import com.example.viewsandcanvas.basics.PreviewContract
import com.example.viewsandcanvas.model.MoviePreview
import com.example.viewsandcanvas.details.DetailsActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : LoadActivity(),
    PreviewContract.ListPreviewsView<MainPresenter>, MovieAdapter.OnItemClickListener {

    private lateinit var presenterMain: MainPresenter
    private val movieAdapter = MovieAdapter(this, this)

    override val progressBar: ProgressBar
        get() = findViewById(R.id.progress_bar)

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
