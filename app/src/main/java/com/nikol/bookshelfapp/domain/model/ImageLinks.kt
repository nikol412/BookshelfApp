package com.nikol.bookshelfapp.domain.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ImageLinks(
    @SerializedName("smallThumbnail")
    @Expose
    val smallThumbnail: String?,
    @SerializedName("thumbnail")
    @Expose
    val thumbnail: String?
)