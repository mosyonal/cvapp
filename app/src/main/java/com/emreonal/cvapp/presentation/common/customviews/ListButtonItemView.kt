package com.emreonal.cvapp.presentation.common.customviews

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.emreonal.cvapp.R
import com.emreonal.cvapp.databinding.LayoutListButtonItemBinding
import com.emreonal.cvapp.util.extensions.inflater

class ListButtonItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = LayoutListButtonItemBinding.inflate(context.inflater(), this, true)

    init {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.list_button_item, 0, 0)
        try {
            typedArray.getString(R.styleable.list_button_item_android_text)?.let {
                binding.tvText.text = it
            }
        } finally {
            typedArray.recycle()
        }
    }

}