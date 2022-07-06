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
        val experiences = ExperienceCreator.create(requireContext())
        binding.llExperiences.removeAllViews()
        experiences.forEach {
            val item = ExperienceItemView(binding.llExperiences.context)
            item.experience = it
            item.listener = this
            binding.llExperiences.addView(item)
        }
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