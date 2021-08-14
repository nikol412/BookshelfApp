package com.nikol.bookshelfapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.nikol.bookshelfapp.domain.repository.BooksService
import com.nikol.bookshelfapp.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class MainViewModel(private val service: BooksService) : BaseViewModel() {

    fun fetchData() {
        compositeDisposable.add(
            service.fetchBooks("Harry Potter")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                           Log.d("Retrofit", "response retrieved: ${it.id}")
                }, {
                    Log.d("Retrofit", "${it.message}")
                })
        )
    }

}