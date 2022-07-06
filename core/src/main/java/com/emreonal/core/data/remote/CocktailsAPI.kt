package com.emreonal.core.data.remote

import com.emreonal.core.data.remote.dto.cocktail.CocktailsResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CocktailsAPI {

    @GET("filter.php?c=Cocktail")
    suspend fun getCocktails(): CocktailsResponse

    @POST("search.php")
    suspend fun getCocktailsByName(@Query("s") query: String): CocktailsResponse

    @POST("lookup.php")
    suspend fun getCocktailsById(@Query("i") id: String?): CocktailsResponse

}