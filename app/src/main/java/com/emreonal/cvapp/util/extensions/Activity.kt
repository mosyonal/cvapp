package com.emreonal.cvapp.util.extensions

import android.app.Activity
import android.view.WindowManager

fun Activity?.hideBars() {
    this?.window?.setFlags(
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
    )
}

fun Activity?.showBars() {
    this?. window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
}