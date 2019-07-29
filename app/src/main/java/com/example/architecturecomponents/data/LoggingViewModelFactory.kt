package com.example.architecturecomponents.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LoggingViewModelFactory(var loggingInterceptor: ClickLoggingInterceptor) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoggingViewModel::class.java)) {
            return LoggingViewModel(loggingInterceptor) as T
        }

        throw IllegalArgumentException()
    }
}