package com.emreonal.cvapp.di

import com.emreonal.core.data.remote.CocktailsAPI
import com.emreonal.core.data.repository.cocktail.CocktailsRepository
import com.emreonal.core.data.repository.cocktail.CocktailsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CocktailsModule {

    @Provides
    @Singleton
    fun provideCocktailsRepository(
        api: CocktailsAPI,
    ): CocktailsRepository {
        return CocktailsRepositoryImpl(api)
    }

}