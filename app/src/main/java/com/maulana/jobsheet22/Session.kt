package com.maulana.jobsheet22

import android.content.Context
import android.content.SharedPreferences

class Session(context: Context) {
    private val  USENAME_KEY = "key_username"
    private val NAMA_LENGKAP_KEY = "key_nama_lengkap"

    private var preferences: SharedPreferences = context.getSharedPreferences("login app", Context.MODE_PRIVATE)

    fun getUser(): String?{
        return preferences.getString(NAMA_LENGKAP_KEY, null)
    }

    fun  setSession(username: String?, nama_lengkap: String?) {
        preferences.edit().putString(USENAME_KEY, username)
            .apply()

        preferences.edit().putString(NAMA_LENGKAP_KEY, nama_lengkap)
            .apply()
    }

    fun isLoggedIn(): Boolean {
        val username = preferences.getString(USENAME_KEY, null)
        return  username != null
    }

    fun validate(username: String, password: String): Boolean {
        val namalengkap = "maulana zahrony"
        if (username == "admin" && password == "admin123") {
            setSession(username, namalengkap)
            return true
        }
        if (username == "Radiva" && password == "Radiva123") {
            setSession(username, namalengkap)
            return true
        }
        if (username == "3007" && password == "3007") {
            setSession(username, namalengkap)
            return true
        }
        return false
    }

    fun logout() {
        preferences.edit().remove(USENAME_KEY)
            .remove(NAMA_LENGKAP_KEY)
            .apply()
    }
}