package com.emreonal.core.data.remote.dto.cocktail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CocktailsResponse (
    val drinks: List<Cocktail>?
): Parcelable