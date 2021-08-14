package com.nikol.bookshelfapp.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BooksSearchResponse(
    @Expose
    @SerializedName("id")
    val id: String? = null
)
