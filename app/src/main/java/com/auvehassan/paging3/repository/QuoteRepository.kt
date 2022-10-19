package com.auvehassan.paging3.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.auvehassan.paging3.paging.QuotePagingSource
import com.auvehassan.paging3.retrofit.QuoteApi
import javax.inject.Inject

class QuoteRepository @Inject constructor(val quoteApi: QuoteApi) {
    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = {QuotePagingSource(quoteApi)}
    ).liveData
}