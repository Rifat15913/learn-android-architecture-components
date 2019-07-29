package com.example.architecturecomponents.data

import android.util.Log

class ClickLoggingInterceptor {
    fun logCount(count: Int) {
        Log.v(this::class.java.simpleName, count.toString())
    }
}