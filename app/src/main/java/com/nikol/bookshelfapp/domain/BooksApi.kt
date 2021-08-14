package com.nikol.bookshelfapp.domain

import com.nikol.bookshelfapp.domain.model.BooksSearchResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApi {
    @GET("volumes")
    fun getVolumes(
        @Query("q") query: String? = null,
        @Query("intitle") title: String? = null,
        @Query("inauthor") author: String? = null,
        @Query("inpublisher") publisher: String? = null,
        @Query("subject") subject: String? = null
    ): Single<BooksSearchResponse>
}