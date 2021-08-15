package com.nikol.bookshelfapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.nikol.bookshelfapp.domain.interactor.BooksInteractor
import com.nikol.bookshelfapp.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class MainViewModel(private val booksInteractor: BooksInteractor) : BaseViewModel() {

    val text = MutableLiveData<String>()

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
                .subscribe({
                    text.value =
                        it.bookItemResponses?.getOrNull(0)?.volumeInfo?.title + it.bookItemResponses?.getOrNull(
                            0
                        )?.volumeInfo?.authors
                }, {
                    Log.d("Retrofit", "${it.message}")
                })
        )
    }

}