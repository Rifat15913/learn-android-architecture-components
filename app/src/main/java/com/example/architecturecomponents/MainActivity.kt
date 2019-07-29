package com.example.architecturecomponents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_view_click.text = (count).toString()
        text_view_click.setRipple(R.color.colorPrimary50)

        text_view_click.setOnClickListener {
            text_view_click.text = (++count).toString()
        }
    }
}
