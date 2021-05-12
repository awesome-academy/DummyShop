package com.sun.dummyshop.data.source.remote

import com.sun.dummyshop.data.model.CategoryResponse
import com.sun.dummyshop.data.model.ProductResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("products/toprated")
    fun getTopRatingProducts(): Observable<ProductResponse>

    @GET("products/topsales")
    fun getTopSellingProducts(): Observable<ProductResponse>

    @GET("departments")
    fun getCategories(): Observable<CategoryResponse>

    @GET("departments/{department_id}/toprated")
    fun getProductsOfCategory(@Path("department_id") categoryId: String): Observable<ProductResponse>
}
