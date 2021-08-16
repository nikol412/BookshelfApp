package com.nikol.bookshelfapp.domain

import com.nikol.bookshelfapp.domain.model.BooksSearchResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApi {
    @GET("volumes")
    fun searchBooks(@Query("q") query: String? = null): Single<BooksSearchResponse>
}