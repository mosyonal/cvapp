package com.emreonal.cvapp.presentation.skills

import com.emreonal.cvapp.R
import com.emreonal.cvapp.databinding.FragmentSkillsBinding
import com.emreonal.cvapp.presentation.base.BaseFragment

class SkillsFragment: BaseFragment<FragmentSkillsBinding>(R.layout.fragment_skills) {

    override fun onDataBound() {
        binding.toolbarLayout.registerActivity(activity)
        binding.skills = SkillsCreator.skills
        binding.tools = SkillsCreator.tools
    }

}