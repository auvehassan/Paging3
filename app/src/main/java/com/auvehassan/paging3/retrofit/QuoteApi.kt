package com.auvehassan.paging3.retrofit

import com.auvehassan.paging3.model.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): QuoteList
}