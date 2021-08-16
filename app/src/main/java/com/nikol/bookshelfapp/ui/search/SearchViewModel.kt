package com.nikol.bookshelfapp.ui.search

import androidx.lifecycle.MutableLiveData
import com.nikol.bookshelfapp.domain.interactor.BooksInteractor
import com.nikol.bookshelfapp.ui.base.BaseViewModel
import com.nikol.bookshelfapp.ui.filters.adapter.BookFilterItem
import com.nikol.bookshelfapp.ui.filters.adapter.BooksFilterEnum
import com.nikol.bookshelfapp.ui.search.adapter.SearchBookItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class SearchViewModel(private val booksInteractor: BooksInteractor) : BaseViewModel() {

    companion object {
        val filterList = listOf(
            BookFilterItem("Поиск по всему", BooksFilterEnum.ALL),
            BookFilterItem("Поиск по автору", BooksFilterEnum.AUTHOR),
            BookFilterItem("Поиск по названию", BooksFilterEnum.TITLE),
            BookFilterItem("Поиск по жанру", BooksFilterEnum.SUBJECT),
            BookFilterItem("Поиск по издателю", BooksFilterEnum.PUBLISHER)
        )
    }

    var currentQuery = ""
        private set

    var filterParameter: BooksFilterEnum? = BooksFilterEnum.ALL

    val booksListLD: MutableLiveData<List<SearchBookItem>> = MutableLiveData()

    fun getSelectedFilterPosition(): Int? {
        val filterItem = filterList.find { it.parameter == filterParameter }
        var index = filterList.indexOf(filterItem)
        return if (index != -1) index else null
    }

    fun fetchData(query: String) {
        currentQuery = query

        if (query.isBlank()) {
            booksListLD.value = emptyList()
            return
        }
        val preparedQuery = filterParameter?.key + ":" + query
        loadBooks(preparedQuery)
    }

    fun onFilterClick(param: BooksFilterEnum) {
        filterParameter = param
    }

    private fun loadBooks(query: String) {
        compositeDisposable.add(
            booksInteractor.searchBooks(query)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoading.value = true }
                .doFinally { isLoading.value = false }
                .subscribe({ responseBooksList ->
                    if (currentQuery.isBlank()) booksListLD.value = emptyList()
                    else booksListLD.value = responseBooksList
                }, {
                    //ignored now
                })
        )
    }
}