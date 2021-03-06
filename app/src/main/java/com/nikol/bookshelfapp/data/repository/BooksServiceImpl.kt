package com.nikol.bookshelfapp.data.repository

import com.nikol.bookshelfapp.domain.BooksApi
import com.nikol.bookshelfapp.domain.model.BooksSearchResponse
import com.nikol.bookshelfapp.domain.repository.BooksService
import io.reactivex.rxjava3.core.Single

class BooksServiceImpl(private val api: BooksApi) : BooksService {
    override fun searchBooks(query: String): Single<BooksSearchResponse> {
        return api.searchBooks(query)
    }
}