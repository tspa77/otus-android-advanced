package com.example.mvppattern.mvp.view

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvppattern.AppConstants.MOVIE_ID
import com.example.mvppattern.R
import com.example.mvppattern.adapter.MovieAdapter
import com.example.mvppattern.contracts.PreviewContract
import com.example.mvppattern.data.MoviePreview
import com.example.mvppattern.mvp.presenter.MainPresenter
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
