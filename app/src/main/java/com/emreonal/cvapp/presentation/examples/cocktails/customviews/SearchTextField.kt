package com.emreonal.cvapp.presentation.examples.cocktails.customviews

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.doOnTextChanged
import com.emreonal.cvapp.databinding.LayoutSearchTextFieldBinding
import com.emreonal.cvapp.util.extensions.inflater
import kotlinx.coroutines.flow.MutableStateFlow

class SearchTextField @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = LayoutSearchTextFieldBinding.inflate(context.inflater(), this, true)

    var listener: ISearchTextField? = null
    var queryFlow = MutableStateFlow("")

    var clearDisabled = false
        set(value) {
            binding.showClear = !value
            field = value
        }

    init {

        binding.etInput.doOnTextChanged { text, _, _, _ ->
            binding.showClear = !text.isNullOrEmpty() && !clearDisabled
            binding.hideHint = !text.isNullOrEmpty()
            if (text.isNullOrEmpty()) listener?.onTextCleared()
            queryFlow.value = text?.toString() ?: ""
            listener?.onTextChanged(text?.toString())
        }
        binding.etInput.setOnFocusChangeListener { _, hasFocus ->
            binding.hideHint = hasFocus || !binding.etInput.text.isNullOrEmpty()
        }
        binding.ivRight.setOnClickListener {
            binding.etInput.setText("")
        }

    }

    override fun clearFocus() {
        binding.etInput.clearFocus()
    }

    fun clear() {
        queryFlow.value = ""
        listener?.onTextCleared()
        binding.etInput.text?.clear()
    }
}