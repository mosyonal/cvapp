package com.emreonal.cvapp.presentation.examples.cocktails.detail

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.emreonal.cvapp.R
import com.emreonal.cvapp.databinding.FragmentCocktailDetailsBinding
import com.emreonal.cvapp.presentation.base.BaseFragment
import com.emreonal.cvapp.presentation.examples.cocktails.detail.adapter.CocktailIngredientsAdapter
import com.emreonal.cvapp.util.extensions.findSafeNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CocktailDetailsFragment: BaseFragment<FragmentCocktailDetailsBinding>(R.layout.fragment_cocktail_details) {

    private lateinit var adapter: CocktailIngredientsAdapter
    private val viewModel: CocktailDetailsViewModel by viewModels()
    private val args: CocktailDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = CocktailIngredientsAdapter()
        lifecycleScope.launchWhenCreated {
            viewModel.cocktailDetails(args.argCocktailId)
        }
    }

    override fun onDataBound() {
        handleState(viewModel)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.mcvBack.setOnClickListener { findSafeNavController()?.popBackStack()  }
        binding.rvIngredients.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.rvIngredients.setHasFixedSize(true)
        binding.rvIngredients.adapter = adapter

        viewModel.detail.observe(viewLifecycleOwner) {
            it.ingredients?.let { ingredients ->
                adapter.list = ingredients
            }
        }
    }

}