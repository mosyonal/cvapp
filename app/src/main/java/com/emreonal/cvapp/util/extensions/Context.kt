package com.emreonal.cvapp.util.extensions

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun Context.inflater(): LayoutInflater =
    if (this is Activity) this.layoutInflater else LayoutInflater.from(this)

fun Context.color(@ColorRes colorResId: Int, theme: Resources.Theme? = null): Int =
    ContextCompat.getColor(this, colorResId )
