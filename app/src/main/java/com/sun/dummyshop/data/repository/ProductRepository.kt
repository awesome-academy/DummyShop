package com.sun.dummyshop.data.repository

import com.sun.dummyshop.data.model.Product
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface ProductRepository {
    fun getFavoriteProducts(): Observable<List<Product>>
    fun insertFavoriteProduct(product: Product): Completable
    fun deleteFavoriteProduct(product: Product): Completable
    fun updateFavoriteProduct(product: Product): Completable
    fun isFavoriteProduct(id: String): Single<Boolean>
    fun getTopRatingProducts(): Observable<List<Product>>
    fun getTopSellingProducts(): Observable<List<Product>>
}
