package com.emreonal.core.domain.mapper.cocktail

import com.emreonal.core.data.local.entity.cocktail.CocktailDetailEntity
import com.emreonal.core.data.remote.dto.cocktail.Cocktail
import com.emreonal.core.domain.mapper.Mapper

class CocktailDetailMapper: Mapper<CocktailDetailEntity, Cocktail> {
    override fun mapFromEntity(item: CocktailDetailEntity?): Cocktail? {
        return null
    }

    override fun mapToEntity(item: Cocktail?): CocktailDetailEntity? {
        val entity = CocktailDetailEntity()

        entity.name = item?.strDrink
        entity.category = item?.strCategory
        entity.glass = item?.strGlass
        entity.imageUrl = item?.strDrinkThumb
        entity.instructions = item?.strInstructions

        val ingredients = mutableListOf<Map<String, String>>()

        if (item == null || item.strIngredient1.isNullOrEmpty()) {
            return entity
        }

        val ingredient1 = mapOf(item.strIngredient1 to item.strMeasure1!!)
        ingredients.add(ingredient1)

        if (item.strIngredient2.isNullOrEmpty()) {
            entity.ingredients = ingredients
            return entity
        }

        val ingredient2 = mapOf(item.strIngredient2 to item.strMeasure2!!)
        ingredients.add(ingredient2)

        if (item.strIngredient3.isNullOrEmpty()) {
            entity.ingredients = ingredients
            return entity
        }

        val ingredient3 = mapOf(item.strIngredient3 to item.strMeasure3!!)
        ingredients.add(ingredient3)

        if (item.strIngredient4.isNullOrEmpty()) {
            entity.ingredients = ingredients
            return entity
        }

        val ingredient4 = mapOf(item.strIngredient4 to item.strMeasure4!!)
        ingredients.add(ingredient4)

        if (item.strIngredient5.isNullOrEmpty()) {
            entity.ingredients = ingredients
            return entity
        }

        val ingredient5 = mapOf(item.strIngredient5 to item.strMeasure5!!)
        ingredients.add(ingredient5)

        if (item.strIngredient6.isNullOrEmpty()) {
            entity.ingredients = ingredients
            return entity
        }

        val ingredient6 = mapOf(item.strIngredient6 to item.strMeasure6!!)
        ingredients.add(ingredient6)

        if (item.strIngredient7.isNullOrEmpty()) {
            entity.ingredients = ingredients
            return entity
        }

        val ingredient7 = mapOf(item.strIngredient7 to item.strMeasure7!!)
        ingredients.add(ingredient7)

        if (item.strIngredient8.isNullOrEmpty()) {
            entity.ingredients = ingredients
            return entity
        }

        val ingredient8 = mapOf(item.strIngredient8 to item.strMeasure8!!)
        ingredients.add(ingredient8)

        if (item.strIngredient9.isNullOrEmpty()) {
            entity.ingredients = ingredients
            return entity
        }

        val ingredient9 = mapOf(item.strIngredient9 to item.strMeasure9!!)
        ingredients.add(ingredient9)

        if (item.strIngredient10.isNullOrEmpty()) {
            entity.ingredients = ingredients
            return entity
        }

        val ingredient10 = mapOf(item.strIngredient10 to item.strMeasure10!!)
        ingredients.add(ingredient10)

        if (item.strIngredient11.isNullOrEmpty()) {
            entity.ingredients = ingredients
            return entity
        }

        val ingredient11 = mapOf(item.strIngredient11 to item.strMeasure11!!)
        ingredients.add(ingredient11)

        if (item.strIngredient12.isNullOrEmpty()) {
            entity.ingredients = ingredients
            return entity
        }

        val ingredient12 = mapOf(item.strIngredient12 to item.strMeasure12!!)
        ingredients.add(ingredient12)

        if (item.strIngredient13.isNullOrEmpty()) {
            entity.ingredients = ingredients
            return entity
        }

        val ingredient13 = mapOf(item.strIngredient13 to item.strMeasure13!!)
        ingredients.add(ingredient13)

        if (item.strIngredient14.isNullOrEmpty()) {
            entity.ingredients = ingredients
            return entity
        }

        val ingredient14 = mapOf(item.strIngredient14 to item.strMeasure14!!)
        ingredients.add(ingredient14)

        if (item.strIngredient15.isNullOrEmpty()) {
            entity.ingredients = ingredients
            return entity
        }

        val ingredient15 = mapOf(item.strIngredient15 to item.strMeasure15!!)
        ingredients.add(ingredient15)

        entity.ingredients = ingredients
        return entity
    }
}