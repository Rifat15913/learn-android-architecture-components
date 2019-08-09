package com.example.architecturecomponents.ui.main

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.architecturecomponents.R
import com.example.architecturecomponents.data.ClickLoggingInterceptor
import com.example.architecturecomponents.data.LoggingViewModel
import com.example.architecturecomponents.data.LoggingViewModelFactory
import com.example.architecturecomponents.ui.setRipple
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var viewModel: LoggingViewModel? = null
    private val LOG_TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, LoggingViewModelFactory(ClickLoggingInterceptor()))
            .get(LoggingViewModel::class.java)

        text_view_click.text = viewModel?.count.toString()
        text_view_click.setRipple(R.color.colorPrimary50)

        text_view_click.setOnClickListener {
            viewModel?.count = viewModel?.count?.inc()!!

            // Here is the debug log message
            Log.w(LOG_TAG, "The value is: $Random.nextInt(0, 9). Is it between 0 and 9?")

            val randomValue = Random.nextInt(0, 9)

            // Here is the warning log message
            Log.w(LOG_TAG, "The value is: $randomValue. (It should not be zero)")

            try {
                viewModel?.count = viewModel?.count!! / randomValue
                text_view_click.text = (viewModel?.count).toString()
                Log.i(LOG_TAG, (viewModel?.count).toString())
            } catch (e: Exception) {
                if (!TextUtils.isEmpty(e.message)) {
                    // Here is the error log message
                    Log.e(LOG_TAG, e.message!!)
                }

                // Here is the full log message of the error
                Log.v(LOG_TAG, e.toString())

                // Here is the log message of the error as WTF
                Log.wtf(LOG_TAG, "What a terrible failure", e)
            }
        }
    }
}
