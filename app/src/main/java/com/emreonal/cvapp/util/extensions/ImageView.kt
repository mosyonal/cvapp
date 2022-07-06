package com.emreonal.cvapp.util.extensions

import android.content.Context
import android.widget.ImageView
import com.emreonal.cvapp.util.GlideApp

fun ImageView.load(
    context: Context,
    url: String?,
) {
    try {
        GlideApp.with(context)
            .load(url)
            .thumbnail(0.5f)
            .dontAnimate()
            .into(this)
    } catch (e: Exception) {
        e.printStackTrace()
        // FirebaseCrashlytics.getInstance().log(e.localizedMessage ?: "Throwable")
    }
}