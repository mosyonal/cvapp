package com.emreonal.cvapp.presentation.common

import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.emreonal.cvapp.databinding.ListItemDotTextBinding
import com.emreonal.cvapp.util.extensions.inflater
import com.emreonal.cvapp.util.extensions.load
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

@BindingAdapter("roundTop", "roundColor")
fun View.roundTop(roundRadiusResource: Int, backgroundColorResource: Int) {
    val model = ShapeAppearanceModel().toBuilder()
        .setTopLeftCorner(CornerFamily.ROUNDED, context.resources.getDimension(roundRadiusResource))
        .setTopRightCorner(CornerFamily.ROUNDED, context.resources.getDimension(roundRadiusResource))
        .build()
    background = MaterialShapeDrawable(model).apply {
        fillColor = ColorStateList.valueOf(ContextCompat.getColor(context, backgroundColorResource))
    }
}

@BindingAdapter("roundBottom", "roundColor")
fun View.roundBottom(roundRadiusResource: Int, backgroundColorResource: Int) {
    val model = ShapeAppearanceModel().toBuilder()
        .setBottomLeftCorner(CornerFamily.ROUNDED, context.resources.getDimension(roundRadiusResource))
        .setBottomRightCorner(CornerFamily.ROUNDED, context.resources.getDimension(roundRadiusResource))
        .build()
    background = MaterialShapeDrawable(model).apply {
        fillColor = ColorStateList.valueOf(ContextCompat.getColor(context, backgroundColorResource))
    }
}

@BindingAdapter("dotTexts")
fun setDotTexts(linearLayout: LinearLayout, list: List<String>?) {
    linearLayout.removeAllViews()
    list?.forEach {
        val item = ListItemDotTextBinding.inflate(linearLayout.context.inflater(), linearLayout, false)
        item.tvText.text = it
        linearLayout.addView(item.root)
    }
}

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    url?.let {
        imageView.isVisible = true
        imageView.load(imageView.context, url)
    } ?: run {
        imageView.isVisible = false
    }
}