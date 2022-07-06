package com.emreonal.core.domain.usecase.cocktail

import com.emreonal.core.data.remote.dto.base.Resource
import com.emreonal.core.data.remote.dto.cocktail.Cocktail
import com.emreonal.core.data.repository.cocktail.CocktailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCocktailsByNameUseCase @Inject constructor(private val repository: CocktailsRepository) {

    operator fun invoke(query: String): Flow<Resource<List<Cocktail>>> = flow {
        emit(Resource.Loading())
        try {
            val response = repository.getCocktailsByName(query)
            if (!response.drinks.isNullOrEmpty()) {
                emit(Resource.Success(response.drinks))
            } else {
                emit(Resource.Error())
            }
        } catch (e: Exception) {
            emit(Resource.Error())
        }

    }

}