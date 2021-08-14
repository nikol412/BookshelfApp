package com.nikol.bookshelfapp.domain.repository

import com.nikol.bookshelfapp.domain.model.BooksSearchResponse
import io.reactivex.rxjava3.core.Single

interface BooksService {

    fun fetchBooks(
        query: String? = null,
        title: String? = null,
        author: String? = null,
        publisher: String? = null,
        subject: String? = null
    ): Single<BooksSearchResponse>
}