package com.sun.dummyshop.data.source.local

import com.sun.dummyshop.data.model.Product
import com.sun.dummyshop.data.source.ProductDataSource
import com.sun.dummyshop.data.source.local.dao.ProductDao
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class ProductLocalDataSource(
    private val productDao: ProductDao
) : ProductDataSource.Local {

    override fun getFavoriteProducts(): Observable<List<Product>> =
        productDao.getFavoriteProducts()

    override fun insertFavoriteProduct(product: Product): Completable =
        productDao.insertFavoriteProduct(product)

    override fun deleteFavoriteProduct(product: Product): Completable =
        productDao.deleteFavoriteProduct(product)

    override fun updateFavoriteProduct(product: Product): Completable =
        productDao.updateFavoriteProduct(product)

    override fun isFavoriteProduct(id: String): Single<Boolean> =
        productDao.getFavoriteProductById(id).map { it.isNotEmpty() }
}
