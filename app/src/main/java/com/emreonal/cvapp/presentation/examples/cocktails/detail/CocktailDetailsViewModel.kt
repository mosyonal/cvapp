package com.emreonal.cvapp.presentation.examples.cocktails.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.emreonal.core.data.local.entity.cocktail.CocktailDetailEntity
import com.emreonal.core.domain.mapper.cocktail.CocktailDetailMapper
import com.emreonal.core.domain.usecase.cocktail.GetCocktailDetailsUseCase
import com.emreonal.cvapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CocktailDetailsViewModel @Inject constructor(
    private val getCocktailDetailsUseCase: GetCocktailDetailsUseCase,
    private val detailMapper: CocktailDetailMapper
): BaseViewModel() {

    private val _detail = MutableLiveData<CocktailDetailEntity>()
    val detail: LiveData<CocktailDetailEntity> = _detail

    suspend fun cocktailDetails(id: String?) {
        getCocktailDetailsUseCase(id).collect {
            handleResource(it) { res ->
                _detail.postValue(detailMapper.mapToEntity(res?.get(0)))
            }
        }
    }


}