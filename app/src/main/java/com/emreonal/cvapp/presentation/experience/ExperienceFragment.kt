package com.emreonal.cvapp.presentation.experience

import com.emreonal.cvapp.R
import com.emreonal.cvapp.databinding.FragmentExperienceBinding
import com.emreonal.cvapp.presentation.base.BaseFragment
import com.emreonal.cvapp.presentation.common.InfoBottomSheetFragment
import com.emreonal.cvapp.presentation.common.customviews.ExperienceItemView
import com.emreonal.cvapp.presentation.common.customviews.IExperienceItem

class ExperienceFragment: BaseFragment<FragmentExperienceBinding>(R.layout.fragment_experience), IExperienceItem {

    override fun onDataBound() {
        binding.toolbarLayout.registerActivity(activity)
        binding.experiences = ExperienceCreator.create(requireContext())
        binding.experienceListener = this
    }

    override fun onInfoClick(info: String?) {
        val infoFragment = InfoBottomSheetFragment.create(info)
        try {
            if (!infoFragment.isAdded && !infoFragment.isVisible) {
                infoFragment.show(childFragmentManager, InfoBottomSheetFragment::class.simpleName)
                childFragmentManager.executePendingTransactions()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}