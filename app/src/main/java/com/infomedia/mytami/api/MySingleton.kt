package com.infomedia.mytami.api

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.Volley
import com.android.volley.RequestQueue



class MySingleton(val context: Context) {

    private var mInstance: MySingleton? = null
    private var mRequestQueue: RequestQueue = getRequestQueue()
//    private var mCtx: Context = context


    @Synchronized
    fun getInstance(context: Context): MySingleton {
        if (mInstance == null) {
            mInstance = MySingleton(context)
        }
        return mInstance as MySingleton
    }

    private fun getRequestQueue(): RequestQueue {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(context.applicationContext)
        }
        return mRequestQueue
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        getRequestQueue().add(req)
    }
}