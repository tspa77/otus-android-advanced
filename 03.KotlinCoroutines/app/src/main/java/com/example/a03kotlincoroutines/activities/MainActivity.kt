package com.example.a03kotlincoroutines.activities

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a03kotlincoroutines.R
import com.example.a03kotlincoroutines.data.MovieAdapter
import com.example.a03kotlincoroutines.mvp.MovieContract
import com.example.a03kotlincoroutines.mvp.model.Movie
import com.example.a03kotlincoroutines.mvp.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MovieContract.View {
    private var listMovies = mutableListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies.adapter = MovieAdapter(listMovies, this)
        rvMovies.layoutManager = LinearLayoutManager(this)

        val mainPresenter = MainPresenter(this)
        mainPresenter.loadListMovies()

    }

    override fun updateListMovies(loadMovies: List<Movie>) {
        listMovies.clear()
        listMovies.addAll(loadMovies)
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
