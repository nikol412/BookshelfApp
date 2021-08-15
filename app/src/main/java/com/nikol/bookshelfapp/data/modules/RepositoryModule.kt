package com.nikol.bookshelfapp.data.modules

import com.nikol.bookshelfapp.data.interactor.BooksInteractorImpl
import com.nikol.bookshelfapp.data.repository.BooksServiceImpl
import com.nikol.bookshelfapp.domain.interactor.BooksInteractor
import com.nikol.bookshelfapp.domain.repository.BooksService
import org.koin.dsl.module

val repositoryModule = module {
    single<BooksService> { BooksServiceImpl(get()) }
    single<BooksInteractor> { BooksInteractorImpl(get()) }
}