package com.example.mvppattern.mvp.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.example.mvppattern.AppConstants.IMAGE_URL
import com.example.mvppattern.AppConstants.MOVIE_ID
import com.example.mvppattern.R
import com.example.mvppattern.mvp.model.MovieDetails
import com.example.mvppattern.mvp.presenter.DetailsPresenter
import com.example.mvppattern.mvp.presenter.DetailsPresenterImpl
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details_view.*

@kotlinx.serialization.UnstableDefault
class DetailsViewActivity : LoadingViewActivity(), DetailsView {

    private lateinit var detailsPresenter: DetailsPresenter

    override val progressBar: ProgressBar
        get() = findViewById(R.id.progress_bar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_view)

        val id = intent.getIntExtra(MOVIE_ID, 0)
        detailsPresenter = DetailsPresenterImpl(this)
        detailsPresenter.getDetails(id)

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
            .load(IMAGE_URL + movieInfo.posterPath)
            .into(iv_poster)
        group_labels.visibility = View.VISIBLE
    }
}
