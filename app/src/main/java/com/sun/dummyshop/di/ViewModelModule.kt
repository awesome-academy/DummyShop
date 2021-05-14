package com.sun.dummyshop.di

import com.sun.dummyshop.ui.category.CategoryViewModel
import com.sun.dummyshop.ui.home.HomeViewModel
import com.sun.dummyshop.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get(), get()) }
    viewModel { CategoryViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}
