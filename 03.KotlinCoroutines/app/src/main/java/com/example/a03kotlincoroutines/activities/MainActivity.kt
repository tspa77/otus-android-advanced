package com.example.a03kotlincoroutines.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a03kotlincoroutines.AppConstans.MOVIE_ID
import com.example.a03kotlincoroutines.R
import com.example.a03kotlincoroutines.data.MovieAdapter
import com.example.a03kotlincoroutines.mvp.MovieContract
import com.example.a03kotlincoroutines.mvp.model.MoviePreview
import com.example.a03kotlincoroutines.mvp.presenter.PresenterPreviews
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MovieContract.ViewList, MovieAdapter.OnItemClickListener {

    private var listPreviews = mutableListOf<MoviePreview>()
    private lateinit var presenterPreviews: PresenterPreviews

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies.adapter = MovieAdapter(listPreviews, this, this)
        rvMovies.layoutManager = LinearLayoutManager(this)

        presenterPreviews = PresenterPreviews(this)
        presenterPreviews.loadListPreviews()

    }

    override fun onItemClicked(moviePreview: MoviePreview) {
//        Toast.makeText(this, "Ты жамкнул на ${moviePreview.title}", Toast.LENGTH_SHORT).show()
        loadInfoMovie(moviePreview.id, moviePreview.title)
    }

    private fun loadInfoMovie(id: Int, title: String) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra(MOVIE_ID, id)
        startActivity(intent)
    }

    override fun updateListMovies(loadMoviePreviews: List<MoviePreview>) {
        listPreviews.clear()
        listPreviews.addAll(loadMoviePreviews)
        rvMovies.adapter?.notifyDataSetChanged()
    }

    override fun showLoading() {
        showToast("Wait... Loading...")
    }

    override fun hideLoading() {
        showToast("Download completed")
    }

    override fun showError(message: String) {
        showToast(message)
        Log.d("!!!", message)
    }

    private fun showToast(message: String) {
        val toast = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
        toast.apply {
            setGravity(Gravity.CENTER, 0, 500)
            show()
        }
    }
}
