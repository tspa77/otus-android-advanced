package com.example.a03kotlincoroutines.details

import android.os.Bundle
import android.widget.ProgressBar
import com.example.a03kotlincoroutines.AppConstants
import com.example.a03kotlincoroutines.AppConstants.MOVIE_ID
import com.example.a03kotlincoroutines.basics.LoadActivity
import com.example.a03kotlincoroutines.R
import com.example.a03kotlincoroutines.basics.DetailsContract
import com.example.a03kotlincoroutines.model.MovieDetails
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*

class DetailsActivity : LoadActivity(), DetailsContract.BaseViewInfo<DetailsPresenter> {

    private lateinit var presenterInfo: DetailsPresenter

    override val progressBar: ProgressBar
        get() = findViewById(R.id.progress_bar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val id = intent.getIntExtra(MOVIE_ID, 0)
        presenterInfo = DetailsPresenter(this)
        presenterInfo.loadDetailsInfo(id)
    }

    override fun showDetailsInfo(movieInfo: MovieDetails) {
        tv_title.text = movieInfo.title
        tv_release_date.text = movieInfo.releaseDate
        tv_vote.text = movieInfo.voteAverage.toString()
        tv_popularity.text = movieInfo.popularity
        tv_overview.text = movieInfo.overview
        Picasso.get()
            .load(AppConstants.IMAGE_URL + movieInfo.posterPath)
            .into(iv_poster)
    }
}
