package app.demo.example.com.footballapp.utils

import android.support.v7.widget.LinearSmoothScroller
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics

/**
 *
 * Created by Guillermo Bonafonte Criado on 14-Aug-18.
 * 2018 © Cognizant Technology Solutions
 */

fun RecyclerView.getCustomSmoothScroller(): RecyclerView.SmoothScroller {
    return object : LinearSmoothScroller(context) {
        override fun calculateDtToFit(viewStart: Int, viewEnd: Int, boxStart: Int, boxEnd: Int, snapPreference: Int): Int =
                (boxStart + (boxEnd - boxStart) / 2) - (viewStart + (viewEnd - viewStart) / 2)

        override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
            return 200f / displayMetrics.densityDpi
        }
    }
}