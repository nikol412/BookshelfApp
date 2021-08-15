package com.nikol.bookshelfapp.ui.filters

import com.nikol.bookshelfapp.ui.base.BaseViewModel

class FiltersViewModel : BaseViewModel() {
    val filterList = listOf(
        BookFilterItem("Поиск по всему", BooksFilterParams.ALL),
        BookFilterItem("Поиск по автору", BooksFilterParams.AUTHOR),
        BookFilterItem("Поиск по названию", BooksFilterParams.TITLE),
        BookFilterItem("Поиск по жанру", BooksFilterParams.SUBJECT),
        BookFilterItem("Поиск по издателю", BooksFilterParams.PUBLISHER)
    )

    fun onParameterClick(params: BooksFilterParams) {
        //TODO implement navigation to prev screen with enum
    }
}

enum class BooksFilterParams(val key: String) {
    ALL("q"),
    TITLE("intitle"),
    AUTHOR("inauthor"),
    PUBLISHER("inpublisher"),
    SUBJECT("subject")
}

data class BookFilterItem(val title: String, val parameter: BooksFilterParams)