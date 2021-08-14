package com.nikol.bookshelfapp.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.core.KoinComponent

abstract class BaseViewModel: ViewModel(), KoinComponent {
    protected val compositeDisposable = CompositeDisposable()
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}