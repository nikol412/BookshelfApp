package com.nikol.bookshelfapp.domain.interactor

import com.nikol.bookshelfapp.domain.model.BooksSearchResponse
import com.nikol.bookshelfapp.ui.search.adapter.SearchBookItem
import io.reactivex.rxjava3.core.Single

interface BooksInteractor {
    fun fetchBooks(
        query: String,
        title: String? = null,
        author: String? = null,
        publisher: String? = null,
        subject: String? = null
    ): Single<List<SearchBookItem>>
}