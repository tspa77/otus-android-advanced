package com.example.a13tink

import android.app.Application
import com.google.crypto.tink.Aead
import com.google.crypto.tink.KeysetHandle
import com.google.crypto.tink.aead.AeadConfig
import com.google.crypto.tink.aead.AeadKeyTemplates
import com.google.crypto.tink.integration.android.AndroidKeysetManager

/** A custom application that initializes the Tink runtime at application startup.  */
class TinkApplication : Application() {
    companion object {
        private const val PREF_FILE_NAME = "master_pref"
        private const val TINK_KEYSET_NAME = "master_keyset"
        private const val MASTER_KEY_URI = "android-keystore://master_key"
    }

    lateinit var aead: Aead

    override fun onCreate() {
        super.onCreate()

        AeadConfig.register()
        aead = getOrGenerateNewKeysetHandle().getPrimitive(Aead::class.java)
    }


    private fun getOrGenerateNewKeysetHandle(): KeysetHandle =
        AndroidKeysetManager.Builder()
            .withKeyTemplate(AeadKeyTemplates.AES256_GCM)
            .withMasterKeyUri(MASTER_KEY_URI)
            .withSharedPref(applicationContext, TINK_KEYSET_NAME, PREF_FILE_NAME)
            .build()
            .keysetHandle
}
