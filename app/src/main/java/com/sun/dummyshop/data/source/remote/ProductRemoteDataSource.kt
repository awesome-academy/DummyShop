package com.sun.dummyshop.data.source.remote

import com.sun.dummyshop.data.model.ProductResponse
import com.sun.dummyshop.data.source.ProductDataSource
import io.reactivex.rxjava3.core.Observable

class ProductRemoteDataSource(
    private val api: Api
) : ProductDataSource.Remote {

    override fun getTopRatingProducts(): Observable<ProductResponse> = api.getTopRatingProducts()

    override fun getTopSellingProducts(): Observable<ProductResponse> = api.getTopSellingProducts()
}
