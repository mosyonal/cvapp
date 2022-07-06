package com.emreonal.cvapp.presentation.examples.cocktails.main.adapter

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.emreonal.core.data.local.entity.cocktail.CocktailEntity

@BindingAdapter("cocktails")
fun setCocktails(recyclerView: RecyclerView, cocktails: LiveData<List<CocktailEntity>?>?) {
    (recyclerView.adapter as CocktailsAdapter).submitList(cocktails?.value)
}
