package com.example.architecturecomponents.ui

import android.content.res.ColorStateList
import android.graphics.drawable.RippleDrawable
import android.os.Build
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat

/**
 * This file is the collection of all the extension functions to be used in the UI
 * @author Mohd. Asfaq-E-Azam Rifat
 * */

fun View.isVisibile(): Boolean = visibility == View.VISIBLE

fun View.isGone(): Boolean = visibility == View.GONE

fun View.isInvisible(): Boolean = visibility == View.INVISIBLE

fun View.makeItVisible() {
    visibility = View.VISIBLE
}

fun View.makeItInvisible() {
    visibility = View.INVISIBLE
}

fun View.makeItGone() {
    visibility = View.GONE
}

fun View.setRipple(colorResourceId: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        background = RippleDrawable(
            ColorStateList.valueOf(ContextCompat.getColor(this.context, colorResourceId)),
            if (this is ImageView) null else background, null
        )
    }
}