package com.sun.dummyshop.data.source.local.dao

import androidx.room.*
import com.sun.dummyshop.data.model.Product
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface ProductDao {
    @Query("SELECT * FROM product WHERE isFavorite = 1")
    fun getFavoriteProducts(): Observable<List<Product>>

    @Insert
    fun insertFavoriteProduct(product: Product): Completable

    @Delete
    fun deleteFavoriteProduct(product: Product): Completable

    @Update
    fun updateFavoriteProduct(product: Product): Completable

    @Query("SELECT * FROM product WHERE id = :id AND isFavorite = 1")
    fun getFavoriteProductById(id: String): Single<List<Product>>
}
