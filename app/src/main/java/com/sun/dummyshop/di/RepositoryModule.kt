package com.sun.dummyshop.di

import com.sun.dummyshop.data.repository.BillRepository
import com.sun.dummyshop.data.repository.BillRepositoryImpl
import com.sun.dummyshop.data.repository.ProductRepository
import com.sun.dummyshop.data.repository.ProductRepositoryImpl
import com.sun.dummyshop.data.source.BillDataSource
import com.sun.dummyshop.data.source.ProductDataSource
import com.sun.dummyshop.data.source.local.BillLocalDataSource
import com.sun.dummyshop.data.source.local.ProductLocalDataSource
import org.koin.dsl.module

val repositoryModule = module {
    single<ProductDataSource.Local> { ProductLocalDataSource(get()) }
    single<ProductRepository> { ProductRepositoryImpl(get()) }
    single<BillDataSource.Local> { BillLocalDataSource(get()) }
    single<BillRepository> { BillRepositoryImpl(get()) }
}
