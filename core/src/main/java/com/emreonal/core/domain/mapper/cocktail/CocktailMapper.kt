package com.emreonal.core.domain.mapper.cocktail

import com.emreonal.core.data.local.entity.cocktail.CocktailEntity
import com.emreonal.core.data.remote.dto.cocktail.Cocktail
import com.emreonal.core.domain.mapper.Mapper

class CocktailMapper: Mapper<CocktailEntity, Cocktail> {
    override fun mapFromEntity(item: CocktailEntity?): Cocktail? {
        return null
    }

    override fun mapToEntity(item: Cocktail?): CocktailEntity {
        return CocktailEntity(
            item?.idDrink,
            item?.strDrink,
            item?.strDrinkThumb,
            item?.strCategory,
            item?.strGlass
        )
    }
}