package com.example.a13tink

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.crypto.tink.Aead
import com.google.crypto.tink.KeysetHandle
import com.google.crypto.tink.aead.AeadConfig
import com.google.crypto.tink.aead.AeadKeyTemplates
import com.google.crypto.tink.config.TinkConfig
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val associatedData = "These are additional authenticated data (optional)"
    private val key = "ThisIsThe32ByteKeyForEncryption!" // 256 bit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_coder.setOnClickListener { coding() }

    }

    fun coding() {

        TinkConfig.register()
        AeadConfig.register()

        val keysetHandle = KeysetHandle.generateNew(AeadKeyTemplates.AES256_GCM)
        val aead = keysetHandle.getPrimitive(Aead::class.java)

        // Encryption
        val plainText = et_plain_text.text.toString()
        val encrypted = aead.encrypt(
            plainText.toByteArray(Charsets.UTF_8), associatedData.toByteArray(Charsets.UTF_8)
        )
        tv_encrypted.text = encrypted.toString(Charsets.UTF_8)


        // Decryption
//        val encryptedText = tv_encrypted.text.toString()
        val decrypted = aead.decrypt(
            encrypted, associatedData.toByteArray(Charsets.UTF_8)
        )
        tv_decrypted.text = decrypted.toString(Charsets.UTF_8)

    }
}
