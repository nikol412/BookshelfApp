package com.nikol.bookshelfapp.domain.repository

import com.nikol.bookshelfapp.domain.model.BooksSearchResponse
import io.reactivex.rxjava3.core.Single

interface BooksService {

    fun searchBooks(
        query: String,
        title: String? = null,
        author: String? = null,
        publisher: String? = null,
        subject: String? = null
    ): Single<BooksSearchResponse>
}