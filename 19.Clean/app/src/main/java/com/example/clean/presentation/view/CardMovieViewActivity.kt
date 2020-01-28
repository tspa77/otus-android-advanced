package com.example.clean.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.example.clean.R
import com.example.clean.application.App
import com.example.clean.di.component.DaggerCardMovieComponent
import com.example.clean.di.module.CardMovieModule
import com.example.clean.domain.AppConstants.IMAGE_URL
import com.example.clean.domain.AppConstants.MOVIE_ID
import com.example.clean.domain.dto.MovieInfo
import com.example.clean.presentation.presenter.CardMoviePresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details_view.*
import kotlinx.serialization.UnstableDefault
import javax.inject.Inject


@UnstableDefault
class CardMovieViewActivity : BaseLoadingViewActivity(),
    CardMovieView {

    @Inject
    lateinit var cardMoviePresenter: CardMoviePresenter

    override val progressBar: ProgressBar
        get() = findViewById(R.id.progress_bar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_view)
        daggerInject()

        val id = intent.getIntExtra(MOVIE_ID, 0)

        cardMoviePresenter.getMovieInfo(id)

        cv_vote.setOnClickListener { cv_vote.startAnimation() }
        group_labels.visibility = View.INVISIBLE
    }

    override fun showMovieInfo(movieInfo: MovieInfo) {
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

    private fun daggerInject() {
        val appComponent = (application as App).getComponent()
        DaggerCardMovieComponent.builder()
            .appComponent(appComponent)
            .cardMovieModule(CardMovieModule(this))
            .build()
            .inject(this)
    }
}
