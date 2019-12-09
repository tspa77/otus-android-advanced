package com.example.securitytink

import android.app.Application
import android.content.SharedPreferences
import android.util.Base64
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.google.crypto.tink.Aead
import com.google.crypto.tink.aead.AeadKeyTemplates
import com.google.crypto.tink.config.TinkConfig
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.charset.StandardCharsets


class TinkApplication : Application() {

    private val MASTER_KEY_URI = "android-keystore://master_key"
    private val PREF_FILE_NAME = "master_pref"
    private val PREF_KEY = "key"
    private val TINK_KEYSET_NAME = "master_keyset"
    private val TINK_FILE_NAME = "secret_data"
    private val EMPTY_ASSOCIATED_DATA = ByteArray(0)
    private lateinit var mySharedPreferences: SharedPreferences
    private lateinit var encryptedFile: EncryptedFile
    private lateinit var aead: Aead


    override fun onCreate() {
        super.onCreate()

        TinkConfig.register()
        aead = getOrGenerateNewKeysetHandle().getPrimitive(Aead::class.java)

        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        mySharedPreferences = EncryptedSharedPreferences.create(
            PREF_FILE_NAME,
            masterKeyAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, //for encrypting Keys
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM ////for encrypting Values
        )

        val context = applicationContext
        val file = File(context.filesDir, TINK_FILE_NAME)
        encryptedFile = EncryptedFile.Builder(
            file,
            context,
            masterKeyAlias,
            EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
        ).build()
    }

    private fun getOrGenerateNewKeysetHandle() = AndroidKeysetManager.Builder()
        .withSharedPref(
            applicationContext,
            TINK_KEYSET_NAME,
            PREF_FILE_NAME
        )
        .withKeyTemplate(AeadKeyTemplates.AES128_GCM)
        .withMasterKeyUri(MASTER_KEY_URI)
        .build()
        .keysetHandle


    fun encryptString(text: String): String {
        val plainText = text.toByteArray(StandardCharsets.UTF_8)
        val cipherText = aead.encrypt(plainText, EMPTY_ASSOCIATED_DATA)
        return base64Encode(cipherText!!)
    }

    fun decryptString(text: String): String {
        val cipherText = base64Decode(text)
        val plainText = aead.decrypt(cipherText, EMPTY_ASSOCIATED_DATA)
        return String(plainText, StandardCharsets.UTF_8)
    }

    fun writeSP(text: String) =
        mySharedPreferences.edit()
            .putString(PREF_KEY, text)
            .apply()


    fun readSP(): String =
        mySharedPreferences.getString(PREF_KEY, "")!!


    fun writeFile(text: String) {
        val cipherStream = base64Decode(text)
        val encryptedOutputStream = encryptedFile.openFileOutput()

        encryptedOutputStream.use {
            it.write(cipherStream)
        }

//        cipherStream.use {
//            it.copyTo(encryptedOutputStream)
//        }
    }

    fun readFile(): String {
        val encryptedInputStream = encryptedFile.openFileInput()

        val ba = encryptedInputStream.use {
            it.readBytes()
        }


        return base64Encode(ba) ?: ""
    }


    private fun base64Encode(input: ByteArray) = Base64.encodeToString(input, Base64.DEFAULT)
    private fun base64Decode(input: String) = Base64.decode(input, Base64.DEFAULT)
}
