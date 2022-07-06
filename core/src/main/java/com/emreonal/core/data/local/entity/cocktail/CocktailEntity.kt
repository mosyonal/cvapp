package com.emreonal.core.data.local.entity.cocktail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CocktailEntity(
    val id: String?,
    val name: String?,
    val imageUrl: String?,
    val category: String?,
    val glass: String?,
): Parcelable
