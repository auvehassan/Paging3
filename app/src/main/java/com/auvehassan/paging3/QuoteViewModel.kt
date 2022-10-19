package com.auvehassan.paging3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.auvehassan.paging3.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class QuoteViewModel @Inject constructor(repository: QuoteRepository): ViewModel(){

    val quotes = repository.getQuotes().cachedIn(viewModelScope)
}