package com.example.a03kotlincoroutines.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a03kotlincoroutines.AppConstans
import com.example.a03kotlincoroutines.AppConstans.MOVIE_ID
import com.example.a03kotlincoroutines.R
import com.example.a03kotlincoroutines.mvp.MovieContract
import com.example.a03kotlincoroutines.mvp.model.MovieFullInfo
import com.example.a03kotlincoroutines.mvp.presenter.PresenterFullInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity(), MovieContract.ViewInfo {
    private lateinit var presenterInfo: PresenterFullInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val id = intent.getIntExtra(MOVIE_ID, 0)
        presenterInfo = PresenterFullInfo(this)
        presenterInfo.loadFullInfo(id)
    }


    override fun showMovieInfo(movieInfo: MovieFullInfo) {
        tvTitle.text = movieInfo.title
        tvReleaseDate.text = movieInfo.release_date
        tvVote.text = movieInfo.vote_average.toString()
        tvPopularity.text = movieInfo.popularity
        tvOverview.text = movieInfo.overview
        Picasso.get()
            .load(AppConstans.IMAGE_URL + movieInfo.poster_path)
            .into(ivPoster)
    }

    override fun showLoading() {
//        TODO("not implemented")
    }

    override fun hideLoading() {
//        TODO("not implemented")
    }

    override fun showError(message: String) {
//        TODO("not implemented")
    }
}
