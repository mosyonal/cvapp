package com.emreonal.cvapp.presentation.common.customviews

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.emreonal.cvapp.R
import com.emreonal.cvapp.databinding.LayoutToolbarBinding
import com.emreonal.cvapp.util.extensions.color
import com.emreonal.cvapp.util.extensions.inflater

class EgToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = LayoutToolbarBinding.inflate(context.inflater(), this, true)

    init {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.toolbar, 0, 0)
        try {
            typedArray.getString(R.styleable.toolbar_title)?.let {
                binding.tvTitle.text = it
            }
            binding.ivLeft.isVisible = typedArray.getBoolean(R.styleable.toolbar_showBackButton, true)
            binding.toolbar.setBackgroundColor(typedArray.getColor(R.styleable.toolbar_android_background, context.color(R.color.color_primary)))
        } finally {
            typedArray.recycle()
        }
    }

    fun registerActivity(activity: Activity?) {
        (activity as AppCompatActivity?)?.let { appCompatActivity ->
            appCompatActivity.setSupportActionBar(binding.toolbar)
            appCompatActivity.supportActionBar?.setDisplayShowTitleEnabled(false)
            appCompatActivity.supportActionBar?.setDisplayShowCustomEnabled(true)
            binding.ivLeft.setOnClickListener {
                appCompatActivity.onBackPressed()
            }
        }
    }

}