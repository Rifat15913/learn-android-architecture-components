package com.example.architecturecomponents.data

import androidx.lifecycle.ViewModel

open class ClickCounterViewModel : ViewModel() {
    open var count: Int = 0
}