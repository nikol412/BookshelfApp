package com.nikol.bookshelfapp.ui.filters.adapter

enum class BooksFilterEnum(val key: String) {
    ALL("q"),
    TITLE("intitle"),
    AUTHOR("inauthor"),
    PUBLISHER("inpublisher"),
    SUBJECT("subject")
}