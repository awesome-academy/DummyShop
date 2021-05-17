package com.sun.dummyshop.data.repository

import com.sun.dummyshop.data.model.Product
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface ProductRepository {
    fun getFavoriteProducts(): Observable<List<Product>>
    fun insertProduct(product: Product): Completable
    fun deleteFavoriteProduct(product: Product): Completable
    fun updateProduct(product: Product): Completable
    fun isFavoriteProduct(id: String): Single<Boolean>
    fun isAddedToCart(id: String): Single<Boolean>
    fun getProductById(id: String): Single<Product>
    fun getTopRatingProducts(): Observable<List<Product>>
    fun getTopSellingProducts(): Observable<List<Product>>
    fun getProductsOfCategory(id: String): Observable<List<Product>>
    fun getSimilarProducts(id: String): Observable<List<Product>>
}
