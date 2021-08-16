package com.nikol.bookshelfapp.domain.interactor

import com.nikol.bookshelfapp.ui.search.adapter.SearchBookItem
import io.reactivex.rxjava3.core.Single

interface BooksInteractor {
    fun searchBooks(query: String): Single<List<SearchBookItem>>
}