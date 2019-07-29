package com.example.architecturecomponents.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.architecturecomponents.R
import com.example.architecturecomponents.data.ClickLoggingInterceptor
import com.example.architecturecomponents.data.LoggingViewModel
import com.example.architecturecomponents.data.LoggingViewModelFactory
import com.example.architecturecomponents.ui.setRipple
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var viewModel: LoggingViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, LoggingViewModelFactory(ClickLoggingInterceptor()))
            .get(LoggingViewModel::class.java)

        text_view_click.text = viewModel?.count.toString()
        text_view_click.setRipple(R.color.colorPrimary50)

        text_view_click.setOnClickListener {
            viewModel?.count = viewModel?.count?.inc()!!
            text_view_click.text = (viewModel?.count).toString()
        }
    }
}
