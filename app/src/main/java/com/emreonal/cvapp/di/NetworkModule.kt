package com.emreonal.cvapp.di

import android.content.Context
import com.emreonal.core.data.remote.CocktailsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val READ_TIME_OUT = 60.toLong()
    private const val CONNECT_TIME_OUT = 60.toLong()
    private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

    @Provides
    @Singleton
    fun provideOkHttpClient(context: Context) =
        OkHttpClient.Builder()
            .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun provideCocktailService(okHttpClient: OkHttpClient): CocktailsAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(CocktailsAPI::class.java)
    }

}