package com.example.mvppattern.mvp.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.example.mvppattern.AppConstants
import com.example.mvppattern.AppConstants.MOVIE_ID
import com.example.mvppattern.R
import com.example.mvppattern.contracts.DetailsContract
import com.example.mvppattern.data.MovieDetails
import com.example.mvppattern.mvp.presenter.DetailsPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*

class DetailsActivity : LoadActivity(), DetailsContract.BaseViewInfo<DetailsPresenter> {

    private lateinit var presenterInfo: DetailsPresenter

    override val progressBar: ProgressBar
        get() = findViewById(R.id.progress_bar)

    @kotlinx.serialization.UnstableDefault
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val id = intent.getIntExtra(MOVIE_ID, 0)
        presenterInfo =
            DetailsPresenter(this)
        presenterInfo.loadDetailsInfo(id)

        cv_vote.setOnClickListener { cv_vote.startAnimation() }
        group_labels.visibility = View.INVISIBLE
    }

    override fun showDetailsInfo(movieInfo: MovieDetails) {
        tv_title.text = movieInfo.title
        tv_release_date.text = movieInfo.releaseDate
        tv_popularity.text = movieInfo.popularity
        tv_overview.text = movieInfo.overview
        cv_vote.setVote(movieInfo.voteAverage.toFloat())
        Picasso.get()
            .load(AppConstants.IMAGE_URL + movieInfo.posterPath)
            .into(iv_poster)
        group_labels.visibility = View.VISIBLE
    }
}
