package com.example.mvppattern.mvp.view

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvppattern.application.AppConstants.MOVIE_ID
import com.example.mvppattern.R
import com.example.mvppattern.adapter.MovieAdapter
import com.example.mvppattern.mvp.model.MoviePreview
import com.example.mvppattern.mvp.presenter.ListPreviewPresenter
import com.example.mvppattern.mvp.presenter.ListPreviewPresenterImpl
import kotlinx.android.synthetic.main.activity_list_preview_view.*

@kotlinx.serialization.UnstableDefault
class ListPreviewViewActivity : LoadingViewActivity(), ListPreviewView,
    MovieAdapter.OnItemClickListener {

    private lateinit var listPreviewPresenter: ListPreviewPresenter
    private val movieAdapter = MovieAdapter(this, this)

    override val progressBar: ProgressBar
        get() = findViewById(R.id.progress_bar)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_preview_view)

        rv_movies.adapter = movieAdapter
        rv_movies.layoutManager = LinearLayoutManager(this)

        listPreviewPresenter = ListPreviewPresenterImpl(this)
        listPreviewPresenter.getListPreviews()
    }

    override fun onItemClicked(moviePreview: MoviePreview) {
        loadMoviesDetailInfo(moviePreview.id)
    }

    private fun loadMoviesDetailInfo(id: Int) {
        val intent = Intent(this, DetailsViewActivity::class.java)
        intent.putExtra(MOVIE_ID, id)
        startActivity(intent)
    }

    override fun showListPreviews(listPreviews: List<MoviePreview>) =
        movieAdapter.setData(listPreviews)
}
