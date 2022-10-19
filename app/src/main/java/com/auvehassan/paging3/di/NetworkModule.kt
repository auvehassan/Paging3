package com.auvehassan.paging3.di

import com.auvehassan.paging3.retrofit.QuoteApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()


    @Singleton
    @Provides
    fun getQuoteApi(retrofit: Retrofit): QuoteApi = retrofit.create(QuoteApi::class.java)

    companion object{
        private val BASE_URL: String = "https://quotable.io"

    }
}