package com.emreonal.cvapp.util.extensions

import android.os.Build

internal fun hasMinimumSdk(minimumSdk: Int): Boolean {
    return Build.VERSION.SDK_INT >= minimumSdk
}

internal fun hasMaximumSdk(maximumSdk: Int): Boolean {
    return Build.VERSION.SDK_INT <= maximumSdk
}