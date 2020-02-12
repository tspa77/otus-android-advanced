package com.example.card_moview.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.example.card_moview.R
import com.example.card_moview.di.CardMovieModule
import com.example.card_moview.di.DaggerCardMovieComponent
import com.example.card_moview.presenter.CardMoviePresenter
import com.example.core.AppConstants.IMAGE_URL
import com.example.core.AppConstants.MOVIE_ID
import com.example.core.dto.MovieInfo
import com.example.main.App
import com.example.main.view.BaseLoadingViewActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details_view.*
import javax.inject.Inject

@kotlinx.serialization.UnstableDefault
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
