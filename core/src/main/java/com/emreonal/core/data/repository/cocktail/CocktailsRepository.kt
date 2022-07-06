package com.emreonal.core.data.repository.cocktail

import com.emreonal.core.data.remote.dto.cocktail.CocktailsResponse

interface CocktailsRepository {
    suspend fun getInitialCocktails(): CocktailsResponse
    suspend fun getCocktailsByName(query: String): CocktailsResponse
    suspend fun getCocktailsById(id: String?): CocktailsResponse
}