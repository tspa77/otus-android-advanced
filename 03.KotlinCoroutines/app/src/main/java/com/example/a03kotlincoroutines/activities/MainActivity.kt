package com.example.a03kotlincoroutines.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a03kotlincoroutines.AppConstans.MOVIE_ID
import com.example.a03kotlincoroutines.R
import com.example.a03kotlincoroutines.data.Adapter
import com.example.a03kotlincoroutines.mvp.PreviewContract
import com.example.a03kotlincoroutines.mvp.model.MoviePreview
import com.example.a03kotlincoroutines.mvp.presenter.PresenterPreviews
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseLoadActivity(),
    PreviewContract.ViewList<PresenterPreviews>, Adapter.OnItemClickListener {

    private var listPreviews = mutableListOf<MoviePreview>()
    private lateinit var presenterPreviews: PresenterPreviews

    override val progressBar: ProgressBar
        get() = findViewById(R.id.progressBar)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies.adapter = Adapter(listPreviews, this, this)
        rvMovies.layoutManager = LinearLayoutManager(this)

        presenterPreviews = PresenterPreviews(this)
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

    override fun showListPreviews(moviePreviews: List<MoviePreview>) {
        listPreviews.clear()
        listPreviews.addAll(moviePreviews)
        rvMovies.adapter?.notifyDataSetChanged()
    }
}
