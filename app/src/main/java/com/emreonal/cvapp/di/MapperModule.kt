package com.emreonal.cvapp.di

import com.emreonal.core.domain.mapper.cocktail.CocktailDetailMapper
import com.emreonal.core.domain.mapper.cocktail.CocktailMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Singleton
    @Provides
    fun provideCocktailMapper() = CocktailMapper()

    @Singleton
    @Provides
    fun provideCocktailDetailMapper() = CocktailDetailMapper()


}