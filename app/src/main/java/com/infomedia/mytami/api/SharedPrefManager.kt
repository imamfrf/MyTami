package com.infomedia.mytami.api

import android.content.Context
import com.infomedia.mytami.LoginActivity
import android.content.Intent
import android.content.SharedPreferences
import com.infomedia.mytami.model.User
import java.util.*




class SharedPrefManager(val context: Context) {
    //the constants
    private val SHARED_PREF_NAME = "mytamisharedpref"
    private val KEY_USERNAME = "username"
    private val KEY_EMAIL = "email"
    private val KEY_ID = "id"
    private val KEY_NIK = "nik"
    private val KEY_USERLEVEL = "userlevel"
    private val KEY_UNITCODE = "unitcode"
    private val KEY_EXPIRES = "expires"

    private var mInstance: SharedPrefManager? = null
    private val sharedPreferences: SharedPreferences?
            = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)



    @Synchronized
    fun getInstance(context: Context): SharedPrefManager {
        if (mInstance == null) {
            mInstance = SharedPrefManager(context)
        }
        return mInstance as SharedPrefManager
    }

    //method to let the user login
    //this method will store the user data in shared preferences
    fun userLogin(user: User) {
        val editor = sharedPreferences?.edit()
        val date = Date()

        //Set user session for next 7 days
        val millis = date.time?.plus(7 * 24 * 60 * 60 * 1000)
        editor?.putLong(KEY_EXPIRES, millis)
        editor?.putInt(KEY_ID, user.id!!)
        editor?.putString(KEY_USERNAME, user.username)
        editor?.putString(KEY_EMAIL, user.email)
        editor?.putString(KEY_NIK, user.nik)
        editor?.putString(KEY_USERLEVEL, user.userLevel)
        editor?.putString(KEY_UNITCODE, user.unitCode)
        editor?.apply()
    }

    //this method will checker whether user is already logged in or not
    fun isLoggedIn(): Boolean {
        val currentDate = Date()

        val millis = sharedPreferences?.getLong(KEY_EXPIRES, 0)

        /* If shared preferences does not have a value
         then user is not logged in
         */
        if (millis == 0L) {
            return false
        }
        val expiryDate = Date(millis!!)

        /* Check if session is expired by comparing
        current date and Session expiry date
        */
        return currentDate.before(expiryDate)
    }



    //this method will give the logged in user
    fun getUser(): User {
        return User(
            sharedPreferences?.getInt(KEY_ID, 0), sharedPreferences?.getString(KEY_USERNAME, ""),
            sharedPreferences?.getString(KEY_NIK, ""), sharedPreferences?.getString(KEY_USERLEVEL, ""),
            sharedPreferences?.getString(KEY_UNITCODE, ""), sharedPreferences?.getString(KEY_EMAIL, ""),
            Date(sharedPreferences!!.getLong(KEY_EXPIRES, 0)))
    }

    //this method will logout the user
    fun logout() {
        val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
        context.startActivity(Intent(context, LoginActivity::class.java))

    }
}