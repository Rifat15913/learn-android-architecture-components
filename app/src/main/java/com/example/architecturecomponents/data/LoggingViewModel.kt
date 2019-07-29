package com.example.architecturecomponents.data

class LoggingViewModel(var loggingInterceptor: ClickLoggingInterceptor) : ClickCounterViewModel() {
    override var count: Int = 0
        set(value) {
            field = value
            loggingInterceptor.logCount(value)
        }
}