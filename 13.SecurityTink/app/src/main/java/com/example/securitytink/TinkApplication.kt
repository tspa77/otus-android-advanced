package com.example.securitytink

import android.app.Application
import com.google.crypto.tink.Aead
import com.google.crypto.tink.KeysetHandle
import com.google.crypto.tink.aead.AeadKeyTemplates
import com.google.crypto.tink.config.TinkConfig
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import java.io.IOException
import java.security.GeneralSecurityException

/** A custom application that initializes the Tink runtime at application startup.  */
class TinkApplication : Application() {

    companion object {
        private const val PREF_FILE_NAME = "hello_world_pref"
        private const val TINK_KEYSET_NAME = "hello_world_keyset"
        private const val MASTER_KEY_URI = "android-keystore://hello_world_master_key"
    }

    lateinit var aead: Aead

    override fun onCreate() {
        super.onCreate()
        aead = try {
            TinkConfig.register()
            orGenerateNewKeysetHandle.getPrimitive(Aead::class.java)
        } catch (e: GeneralSecurityException) {
            throw RuntimeException(e)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    @get:Throws(IOException::class, GeneralSecurityException::class)
    private val orGenerateNewKeysetHandle: KeysetHandle
        get() = AndroidKeysetManager.Builder()
            .withSharedPref(
                applicationContext,
                TINK_KEYSET_NAME,
                PREF_FILE_NAME
            )
            .withKeyTemplate(AeadKeyTemplates.AES256_GCM)
            .withMasterKeyUri(MASTER_KEY_URI)
            .build()
            .keysetHandle
}
