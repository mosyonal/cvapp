package com.emreonal.cvapp.presentation.examples.cocktails.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.emreonal.core.data.local.entity.cocktail.CocktailEntity
import com.emreonal.core.domain.mapper.cocktail.CocktailMapper
import com.emreonal.core.domain.usecase.cocktail.GetCocktailsByNameUseCase
import com.emreonal.core.domain.usecase.cocktail.GetInitialCocktailsUseCase
import com.emreonal.cvapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class CocktailsViewModel @Inject constructor(
    private val getInitialCocktailsUseCase: GetInitialCocktailsUseCase,
    private val getCocktailsByNameUseCase: GetCocktailsByNameUseCase,
    private val cocktailMapper: CocktailMapper
): BaseViewModel() {

    private val _cocktails = MutableLiveData<List<CocktailEntity>?>()
    private val _initialCocktails = MutableLiveData<List<CocktailEntity>?>()
    val cocktails: LiveData<List<CocktailEntity>?> = _cocktails


    suspend fun getInitialCocktails() {
        getInitialCocktailsUseCase().collect {
            handleResource(it) { response ->
                val cocktails = response?.map { item -> cocktailMapper.mapToEntity(item) }
                _cocktails.postValue(cocktails)
                _initialCocktails.postValue(cocktails)
            }
        }
    }

    @ExperimentalCoroutinesApi
    @FlowPreview
    suspend fun getCocktailsByName(queryFlow: Flow<String>) {
        queryFlow.debounce(DEBOUNCE_TIME)
            .filter {
                return@filter it.length >= MIN_SEARCH_LENGTH
            }
            .flatMapLatest {
                getCocktailsByNameUseCase(it)
            }.collect {
                handleResource(it) { response ->
                    val cocktails = response?.map { item -> cocktailMapper.mapToEntity(item) }
                    _cocktails.postValue(cocktails)
                }
            }
    }

    fun clearSearch() {
        _cocktails.postValue(_initialCocktails.value)
    }

    companion object {
        private const val DEBOUNCE_TIME = 300L
        private const val MIN_SEARCH_LENGTH = 3
    }

}