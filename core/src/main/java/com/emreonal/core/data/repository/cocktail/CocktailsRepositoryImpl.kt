package com.emreonal.core.data.repository.cocktail

import com.emreonal.core.data.remote.CocktailsAPI
import com.emreonal.core.data.remote.dto.cocktail.Cocktail
import com.emreonal.core.data.remote.dto.cocktail.CocktailsResponse
import javax.inject.Inject

class CocktailsRepositoryImpl @Inject constructor(
    private val api: CocktailsAPI
): CocktailsRepository {
    override suspend fun getInitialCocktails(): CocktailsResponse {
        return api.getCocktails()
    }

    override suspend fun getCocktailsByName(query: String): CocktailsResponse {
        return api.getCocktailsByName(query)
    }

    override suspend fun getCocktailsById(id: String?): CocktailsResponse {
        return api.getCocktailsById(id)
    }
}