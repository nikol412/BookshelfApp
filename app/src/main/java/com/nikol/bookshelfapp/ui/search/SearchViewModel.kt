package com.nikol.bookshelfapp.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nikol.bookshelfapp.domain.interactor.BooksInteractor
import com.nikol.bookshelfapp.domain.model.BookItemResponse
import com.nikol.bookshelfapp.ui.base.BaseViewModel
import com.nikol.bookshelfapp.ui.search.adapter.SearchBookItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class MainViewModel(private val booksInteractor: BooksInteractor) : BaseViewModel() {

    val text = MutableLiveData<String>()
    val booksListLD: MutableLiveData<List<SearchBookItem>> = MutableLiveData()

    fun fetchData(
        query: String,
        title: String? = null,
        author: String? = null,
        publisher: String? = null,
        subject: String? = null
    ) {
        compositeDisposable.add(
            booksInteractor.fetchBooks(query, title, author, publisher, subject)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoading.value = true }
                .doFinally { isLoading.value = false }
                .subscribe({ responseBooksList ->
                    booksListLD.value = responseBooksList
                }, {
                    Log.d("Retrofit", "${it.message}")
                })
        )
    }

}