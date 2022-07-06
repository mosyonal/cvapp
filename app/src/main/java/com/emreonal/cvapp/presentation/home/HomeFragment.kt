package com.emreonal.cvapp.presentation.home

import com.emreonal.cvapp.R
import com.emreonal.cvapp.databinding.FragmentHomeBinding
import com.emreonal.cvapp.presentation.base.BaseFragment
import com.emreonal.cvapp.util.extensions.findSafeNavController
import com.emreonal.cvapp.util.extensions.safeNavigate

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home), IHome {

    override fun onDataBound() {
        binding.listener = this

    }

    override fun onExperienceClick() {
        findSafeNavController()?.safeNavigate(R.id.fragment_home,
            HomeFragmentDirections.actionHomeToExperience())
    }

    override fun onSkillsClick() {
        findSafeNavController()?.safeNavigate(R.id.fragment_home,
            HomeFragmentDirections.actionHomeToSkills())
    }

    override fun onEducationClick() {
        findSafeNavController()?.safeNavigate(R.id.fragment_home,
            HomeFragmentDirections.actionHomeToEducation())
    }

    override fun onLanguageOthersClick() {
        findSafeNavController()?.safeNavigate(R.id.fragment_home,
            HomeFragmentDirections.actionHomeToLanguageOthers())
    }

}