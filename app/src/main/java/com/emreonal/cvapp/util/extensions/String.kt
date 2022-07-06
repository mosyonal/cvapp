package com.emreonal.cvapp.util.extensions

import android.os.Build
import android.text.Html
import android.text.Spanned

@Suppress("DEPRECATION")
fun String?.makeHtml(): Spanned? {
    if (this.isNullOrEmpty()) return null
    return if (hasMinimumSdk(Build.VERSION_CODES.N)) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    } else Html.fromHtml(this)
}