package com.emreonal.cvapp.presentation.examples.cocktails.main

import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.GridLayoutManager
import com.emreonal.core.data.local.entity.cocktail.CocktailEntity
import com.emreonal.cvapp.R
import com.emreonal.cvapp.databinding.FragmentCocktailsBinding
import com.emreonal.cvapp.presentation.base.BaseFragment
import com.emreonal.cvapp.presentation.examples.cocktails.customviews.ISearchTextField
import com.emreonal.cvapp.presentation.examples.cocktails.main.adapter.CocktailsAdapter
import com.emreonal.cvapp.util.extensions.findSafeNavController
import com.emreonal.cvapp.util.extensions.safeNavigate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class CocktailsFragment : BaseFragment<FragmentCocktailsBinding>(R.layout.fragment_cocktails),
    ICocktails, ISearchTextField {

    private val viewModel: CocktailsViewModel by viewModels()
    private lateinit var adapter: CocktailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = CocktailsAdapter(this)
        lifecycleScope.launchWhenCreated {
            delay(3000)
            viewModel.getInitialCocktails()
        }
    }

    override fun onDataBound() {
        handleState(viewModel)
        binding.viewModel = viewModel
        binding.searchTextField.listener = this
        binding.rvCocktails.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvCocktails.adapter = adapter

        lifecycleScope.launchWhenStarted {
            delay(3000)
            viewModel.getCocktailsByName(binding.searchTextField.queryFlow)
        }

    }

    override fun setLoadingIndicator(
        loading: Boolean,
        rootVisible: Boolean,
    ) {
        binding.rvCocktails.isVisible = !loading
        binding.lottie.isVisible = loading
    }

    override fun onTextChanged(text: String?) {

    }

    override fun onTextCleared() {
        viewModel.clearSearch()
    }

    override fun onCocktailClick(cocktail: CocktailEntity, imageView: ImageView) {
        findSafeNavController()?.safeNavigate(R.id.fragment_cocktails, CocktailsFragmentDirections.actionToCocktailDetails(cocktail.id))
    }

}