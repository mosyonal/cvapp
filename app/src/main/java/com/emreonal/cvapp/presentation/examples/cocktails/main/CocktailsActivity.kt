package com.emreonal.cvapp.presentation.examples.cocktails.main

import android.view.LayoutInflater
import com.emreonal.cvapp.databinding.ActivityCocktailsBinding
import com.emreonal.cvapp.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CocktailsActivity: BaseActivity<ActivityCocktailsBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityCocktailsBinding
        get() = ActivityCocktailsBinding::inflate

    override fun onViewBound() {

    }

}