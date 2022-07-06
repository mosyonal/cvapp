package com.emreonal.cvapp.presentation.examples.cocktails.main

import android.widget.ImageView
import com.emreonal.core.data.local.entity.cocktail.CocktailEntity

interface ICocktails {
    fun onCocktailClick(cocktail: CocktailEntity, imageView: ImageView)
}