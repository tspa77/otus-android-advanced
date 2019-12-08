package com.example.securitytink

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var tinkApp: TinkApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tinkApp = applicationContext as TinkApplication

        et_plain_text.doAfterTextChanged { codingString(it.toString()) }
        btn_save_sp.setOnClickListener { saveSP(et_plain_text.text.toString()) }
        btn_load_sp.setOnClickListener { loadSP() }
    }

    private fun saveSP(text: String?) {
        tinkApp.saveSP(text ?: "")
        Toast.makeText(this, "String saved to Shared Preferences", Toast.LENGTH_SHORT)
            .show()
    }

    private fun loadSP() {
        tv_sp_key.text = tinkApp.loadSP()
        Toast.makeText(this, "String loaded from Shared Preferences", Toast.LENGTH_SHORT)
            .show()
    }

    private fun codingString(text: String?) {
        tv_encrypted.text = tinkApp.encryptString(text ?: "")
        tv_decrypted.text = tinkApp.decryptString(tv_encrypted.text.toString())
    }
}
