package com.example.a03kotlincoroutines.activities

import android.os.Bundle
import android.widget.ProgressBar
import com.example.a03kotlincoroutines.AppConstans
import com.example.a03kotlincoroutines.AppConstans.MOVIE_ID
import com.example.a03kotlincoroutines.R
import com.example.a03kotlincoroutines.mvp.DetailsContract
import com.example.a03kotlincoroutines.mvp.model.MovieDetails
import com.example.a03kotlincoroutines.mvp.presenter.PresenterDetails
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*

class DetailActivity : BaseLoadActivity(), DetailsContract.ViewInfo<PresenterDetails> {

    private lateinit var presenterInfo: PresenterDetails

    override val progressBar: ProgressBar
        get() = findViewById(R.id.progressBar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val id = intent.getIntExtra(MOVIE_ID, 0)
        presenterInfo = PresenterDetails(this)
        presenterInfo.loadDetailsInfo(id)
    }

    override fun showDetailsInfo(movieInfo: MovieDetails) {
        tvTitle.text = movieInfo.title
        tvReleaseDate.text = movieInfo.release_date
        tvVote.text = movieInfo.vote_average.toString()
        tvPopularity.text = movieInfo.popularity
        tvOverview.text = movieInfo.overview
        Picasso.get()
            .load(AppConstans.IMAGE_URL + movieInfo.poster_path)
            .into(ivPoster)
    }
}
