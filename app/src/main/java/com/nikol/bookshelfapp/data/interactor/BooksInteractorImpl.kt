package com.nikol.bookshelfapp.data.interactor

import com.nikol.bookshelfapp.domain.interactor.BooksInteractor
import com.nikol.bookshelfapp.domain.model.BooksSearchResponse
import com.nikol.bookshelfapp.domain.repository.BooksService
import io.reactivex.rxjava3.core.Single

class BooksInteractorImpl(private val booksService: BooksService): BooksInteractor {
    override fun fetchBooks(
        query: String,
        title: String?,
        author: String?,
        publisher: String?,
        subject: String?
    ): Single<BooksSearchResponse> {
        return booksService.searchBooks(query, title, author, publisher, subject)
    }
}