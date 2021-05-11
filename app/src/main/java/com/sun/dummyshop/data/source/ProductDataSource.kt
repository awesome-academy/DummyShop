package com.sun.dummyshop.data.source

import com.sun.dummyshop.data.model.Product
import com.sun.dummyshop.data.model.ProductResponse
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface ProductDataSource {
    interface Local {
        fun getFavoriteProducts(): Observable<List<Product>>
        fun insertFavoriteProduct(product: Product): Completable
        fun deleteFavoriteProduct(product: Product): Completable
        fun updateFavoriteProduct(product: Product): Completable
        fun isFavoriteProduct(id: String): Single<Boolean>
    }

    interface Remote {
        fun getTopRatingProducts(): Observable<ProductResponse>
        fun getTopSellingProducts(): Observable<ProductResponse>
    }
}
