package com.example.mvppattern.mvp.view

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvppattern.AppConstants.MOVIE_ID
import com.example.mvppattern.R
import com.example.mvppattern.adapter.MovieAdapter
import com.example.mvppattern.data.MoviePreview
import kotlinx.android.synthetic.main.activity_main.*


class MainViewActivity : AppCompatActivity(), ShowingView, MovieAdapter.OnItemClickListener {

    private lateinit var presenterMainImpl: MainPresenterImpl
    private val movieAdapter = MovieAdapter(this, this)

    override val progressBar: ProgressBar
        get() = findViewById(R.id.progress_bar)

    @kotlinx.serialization.UnstableDefault
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movies.adapter = movieAdapter
        rv_movies.layoutManager = LinearLayoutManager(this)

        presenterMainImpl = MainPresenterImpl(this)
        presenterMainImpl.loadListPreviews()
    }

    override fun onItemClicked(moviePreview: MoviePreview) {
        loadMoviesDetailInfo(moviePreview.id)
    }

    private fun loadMoviesDetailInfo(id: Int) {
        val intent = Intent(this, ShowingViewActivity::class.java)
        intent.putExtra(MOVIE_ID, id)
        startActivity(intent)
    }

    override fun showListPreviews(listPreviews: List<MoviePreview>) =
        movieAdapter.setData(listPreviews)
}
