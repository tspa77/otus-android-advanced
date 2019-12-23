package com.example.mvppattern.mvp.view

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvppattern.AppConstants.MOVIE_ID
import com.example.mvppattern.R
import com.example.mvppattern.adapter.MovieAdapter
import com.example.mvppattern.application.App
import com.example.mvppattern.di.component.DaggerListPreviewComponent
import com.example.mvppattern.di.component.ListPreviewComponent
import com.example.mvppattern.di.module.ListPreviewPresenterModule
import com.example.mvppattern.di.module.ListPreviewViewModule
import com.example.mvppattern.mvp.model.MoviePreview
import com.example.mvppattern.mvp.presenter.ListPreviewPresenter
import kotlinx.android.synthetic.main.activity_list_preview_view.*
import javax.inject.Inject

@kotlinx.serialization.UnstableDefault
class ListPreviewViewActivity : LoadingViewActivity(), ListPreviewView,
    MovieAdapter.OnItemClickListener {

    @Inject
    lateinit var listPreviewPresenter: ListPreviewPresenter

    //    private lateinit var listPreviewPresenter: ListPreviewPresenter
    private val movieAdapter = MovieAdapter(this, this)

    override val progressBar: ProgressBar
        get() = findViewById(R.id.progress_bar)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_preview_view)

        val appComponent = (application as App).getComponent()

        DaggerListPreviewComponent.builder()
            .appComponent(appComponent)
            .listPreviewViewModule(ListPreviewViewModule(this))
            .build()
            .inject(this)



//        val repository = (application as App).getComponent()!!.getRepository()

        rv_movies.adapter = movieAdapter
        rv_movies.layoutManager = LinearLayoutManager(this)

//        listPreviewPresenter = ListPreviewPresenterImpl(this, repository)
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
