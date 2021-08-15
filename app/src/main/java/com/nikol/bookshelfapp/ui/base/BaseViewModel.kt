package com.nikol.bookshelfapp.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.core.KoinComponent

abstract class BaseViewModel: ViewModel(), KoinComponent {
    protected val compositeDisposable = CompositeDisposable()

    val isLoading = MutableLiveData(false)

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}