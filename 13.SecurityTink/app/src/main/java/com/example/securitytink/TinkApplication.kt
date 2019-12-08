package com.example.securitytink

import android.app.Application
import android.util.Base64
import com.google.crypto.tink.Aead
import com.google.crypto.tink.aead.AeadKeyTemplates
import com.google.crypto.tink.config.TinkConfig
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import java.nio.charset.StandardCharsets

class TinkApplication : Application() {

    private val MASTER_KEY_URI = "android-keystore://master_key"
    private val PREF_FILE_NAME = "master_pref"
    private val TINK_KEYSET_NAME = "master_keyset"
    private val EMPTY_ASSOCIATED_DATA = ByteArray(0)
    lateinit var aead: Aead

    override fun onCreate() {
        super.onCreate()
        TinkConfig.register()
        aead = getOrGenerateNewKeysetHandle().getPrimitive(Aead::class.java)
    }

    private fun getOrGenerateNewKeysetHandle() = AndroidKeysetManager.Builder()
        .withSharedPref(
            applicationContext,
            TINK_KEYSET_NAME,
            PREF_FILE_NAME
        )
        .withKeyTemplate(AeadKeyTemplates.AES256_GCM)
        .withMasterKeyUri(MASTER_KEY_URI)
        .build()
        .keysetHandle


    fun attemptEncrypt(text: String): String {
        val plainText = text.toByteArray(StandardCharsets.UTF_8)
        val cipherText = aead.encrypt(plainText, EMPTY_ASSOCIATED_DATA)
        return base64Encode(cipherText!!)
    }

    fun attemptDecrypt(text: String): String {
        val cipherText = base64Decode(text)
        val plainText = aead.decrypt(cipherText, EMPTY_ASSOCIATED_DATA)
        return String(plainText, StandardCharsets.UTF_8)
    }

    private fun base64Encode(input: ByteArray) = Base64.encodeToString(input, Base64.DEFAULT)
    private fun base64Decode(input: String) = Base64.decode(input, Base64.DEFAULT)


}
