package com.emreonal.cvapp.presentation.examples

import android.content.Intent
import com.emreonal.cvapp.R
import com.emreonal.cvapp.databinding.FragmentExamplesBinding
import com.emreonal.cvapp.presentation.base.BaseFragment
import com.emreonal.cvapp.presentation.examples.cocktails.main.CocktailsActivity

class ExamplesFragment: BaseFragment<FragmentExamplesBinding>(R.layout.fragment_examples), IExamples {

    override fun onDataBound() {
        binding.listener = this
    }

    override fun onCocktailsClick() {
        activity?.startActivity(Intent(requireActivity(), CocktailsActivity::class.java))
    }

    override fun onNotesClick() {

    }

}