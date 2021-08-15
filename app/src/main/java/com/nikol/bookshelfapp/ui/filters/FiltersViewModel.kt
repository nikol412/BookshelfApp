package com.nikol.bookshelfapp.ui.filters

import com.nikol.bookshelfapp.ui.base.BaseViewModel
import com.nikol.bookshelfapp.ui.filters.adapter.BookFilterItem
import com.nikol.bookshelfapp.ui.filters.adapter.BooksFilterEnum

class FiltersViewModel : BaseViewModel() {
    //TODO implement shared viewModel with SearchViewModel, add filterParameter,
    // while retrieving data, apply this parameter
    val filterList = listOf(
        BookFilterItem("Поиск по всему", BooksFilterEnum.ALL),
        BookFilterItem("Поиск по автору", BooksFilterEnum.AUTHOR),
        BookFilterItem("Поиск по названию", BooksFilterEnum.TITLE),
        BookFilterItem("Поиск по жанру", BooksFilterEnum.SUBJECT),
        BookFilterItem("Поиск по издателю", BooksFilterEnum.PUBLISHER)
    )

    fun onParameterClick(params: BooksFilterEnum) {
        //TODO implement navigation to prev screen with enum
    }
}



