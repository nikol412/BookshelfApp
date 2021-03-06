package com.nikol.bookshelfapp.data.modules

import com.nikol.bookshelfapp.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { SearchViewModel(get()) }
}