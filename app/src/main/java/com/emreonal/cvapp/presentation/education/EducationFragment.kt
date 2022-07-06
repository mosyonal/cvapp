package com.emreonal.cvapp.presentation.education

import com.emreonal.cvapp.R
import com.emreonal.cvapp.databinding.FragmentEducationBinding
import com.emreonal.cvapp.presentation.base.BaseFragment

class EducationFragment: BaseFragment<FragmentEducationBinding>(R.layout.fragment_education) {

    override fun onDataBound() {
        binding.toolbarLayout.registerActivity(activity)

    }

}