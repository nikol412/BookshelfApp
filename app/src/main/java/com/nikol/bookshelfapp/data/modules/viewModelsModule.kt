package com.nikol.bookshelfapp.data.modules

import com.nikol.bookshelfapp.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { MainViewModel(get()) }
}