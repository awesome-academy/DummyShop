package com.sun.dummyshop.data.repository

import com.sun.dummyshop.data.model.Product
import com.sun.dummyshop.data.source.ProductDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class ProductRepositoryImpl(
    private val local: ProductDataSource.Local,
    private val remote: ProductDataSource.Remote
) : ProductRepository {

    override fun getFavoriteProducts(): Observable<List<Product>> =
        local.getFavoriteProducts()

    override fun insertFavoriteProduct(product: Product): Completable =
        local.insertFavoriteProduct(product)

    override fun deleteFavoriteProduct(product: Product): Completable =
        local.deleteFavoriteProduct(product)

    override fun updateFavoriteProduct(product: Product): Completable =
        local.updateFavoriteProduct(product)

    override fun isFavoriteProduct(id: String): Single<Boolean> =
        local.isFavoriteProduct(id)

    override fun getTopRatingProducts(): Observable<List<Product>> =
        remote.getTopRatingProducts().map { it.data }

    override fun getTopSellingProducts(): Observable<List<Product>> =
        remote.getTopSellingProducts().map { it.data }
}
