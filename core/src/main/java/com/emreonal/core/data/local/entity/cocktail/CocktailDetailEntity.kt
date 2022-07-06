package com.emreonal.core.data.local.entity.cocktail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CocktailDetailEntity(
    var name: String? = null,
    var imageUrl: String? = null,
    var category: String? = null,
    var glass: String? = null,
    var ingredients: List<Map<String, String>>? = null,
    var instructions: String? = null,
) : Parcelable