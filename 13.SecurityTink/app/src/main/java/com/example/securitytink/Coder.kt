package com.example.securitytink

import android.content.Context
import android.util.Base64
import java.nio.charset.StandardCharsets

class Coder(private val applicationContext: Context) {

    private val EMPTY_ASSOCIATED_DATA = ByteArray(0)
    private var tinkApp = applicationContext as TinkApplication


    fun attemptEncrypt(text: String): String {
        return try {
            val plainText = text.toByteArray(StandardCharsets.UTF_8)
            val cipherText = tinkApp.aead.encrypt(plainText, EMPTY_ASSOCIATED_DATA)
            base64Encode(cipherText!!)
        } catch (e: Exception) {
            "${applicationContext.getString(R.string.error_cannot_encrypt)}: $e"
        }
    }

    fun attemptDecrypt(text: String): String {
        return try {
            val cipherText = base64Decode(text)
            val plainText = tinkApp.aead.decrypt(cipherText, EMPTY_ASSOCIATED_DATA)
            String(plainText, StandardCharsets.UTF_8)
        } catch (e: Exception) {
            "${applicationContext.getString(R.string.error_cannot_encrypt)}: $e"
        }
    }

    private fun base64Encode(input: ByteArray) = Base64.encodeToString(input, Base64.DEFAULT)
    private fun base64Decode(input: String) = Base64.decode(input, Base64.DEFAULT)
}
