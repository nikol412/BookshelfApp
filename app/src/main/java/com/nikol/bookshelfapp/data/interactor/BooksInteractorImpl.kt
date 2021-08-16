package com.nikol.bookshelfapp.data.interactor

import com.nikol.bookshelfapp.domain.interactor.BooksInteractor
import com.nikol.bookshelfapp.domain.repository.BooksService
import com.nikol.bookshelfapp.ui.search.adapter.SearchBookItem
import io.reactivex.rxjava3.core.Single

class BooksInteractorImpl(private val booksService: BooksService) : BooksInteractor {
    override fun searchBooks(query: String): Single<List<SearchBookItem>> {
        return booksService.searchBooks(query)
            .flatMap { booksResponse ->
                return@flatMap Single.just(booksResponse.bookItemResponses?.map { bookItem ->
                    SearchBookItem(
                        bookItem.volumeInfo?.title,
                        bookItem.volumeInfo?.imageLinks?.smallThumbnail,
                        bookItem.volumeInfo?.authors.toString()
                    )
                }
                )
            }
    }
}