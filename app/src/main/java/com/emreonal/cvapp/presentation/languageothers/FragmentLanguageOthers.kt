package com.emreonal.cvapp.presentation.languageothers

import com.emreonal.cvapp.R
import com.emreonal.cvapp.databinding.FragmentLanguageOthersBinding
import com.emreonal.cvapp.presentation.base.BaseFragment

class FragmentLanguageOthers: BaseFragment<FragmentLanguageOthersBinding>(R.layout.fragment_language_others) {

    override fun onDataBound() {
        binding.toolbarLayout.registerActivity(activity)
    }

}