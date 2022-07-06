package com.emreonal.cvapp.presentation.common

import android.text.method.LinkMovementMethod
import com.emreonal.cvapp.R
import com.emreonal.cvapp.databinding.FragmentInfoBinding
import com.emreonal.cvapp.presentation.base.BaseBottomSheetFragment
import com.emreonal.cvapp.util.extensions.makeHtml

class InfoBottomSheetFragment : BaseBottomSheetFragment<FragmentInfoBinding>(R.layout.fragment_info,
    fullPage = false,
    draggable = true) {

    var info: String? = null

    override fun onDataBound() {
        binding.tvText.text = info.makeHtml()
        binding.tvText.movementMethod = LinkMovementMethod.getInstance()
        binding.ibClose.setOnClickListener { dismiss() }
    }

    companion object {
        fun create(info: String?): InfoBottomSheetFragment {
            val fragment = InfoBottomSheetFragment()
            fragment.info = info
            return fragment
        }
    }

}