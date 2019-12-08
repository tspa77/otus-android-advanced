package com.example.securitytink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var coder: Coder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coder = Coder(applicationContext)

        et_plain_text.doAfterTextChanged { codingString(it.toString()) }
    }


    private fun codingString(text: String?) {
        if (!text.isNullOrEmpty()) {
            tv_encrypted.text = coder.attemptEncrypt(text)
            tv_decrypted.text = coder.attemptDecrypt(tv_encrypted.text.toString())
        } else {
            tv_encrypted.text = ""
            tv_decrypted.text = ""
        }
    }
}
