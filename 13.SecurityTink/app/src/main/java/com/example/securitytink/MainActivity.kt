package com.example.securitytink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_plain_text.doAfterTextChanged { codingString(it.toString()) }


    }


    private fun codingString(text: String?) {


        tv_encrypted.text = text

    }
}

