package com.example.main.view

import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.main.view.BaseLoadingView


abstract class BaseLoadingViewActivity : AppCompatActivity(),
    BaseLoadingView {

    abstract val progressBar: ProgressBar

    override fun showLoading() {
        Log.d("MY_TAG", "loading")
        progressBar.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        Log.d("MY_TAG", "complete loading")
        progressBar.visibility = ProgressBar.INVISIBLE
    }

    override fun showError(message: String) {
        Log.d("MY_TAG", message)
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
}
