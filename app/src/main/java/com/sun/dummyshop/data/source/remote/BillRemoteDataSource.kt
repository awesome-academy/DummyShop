package com.sun.dummyshop.data.source.remote

import com.sun.dummyshop.data.model.Bill
import com.sun.dummyshop.data.model.CheckoutBody
import com.sun.dummyshop.data.source.BillDataSource
import io.reactivex.rxjava3.core.Single

class BillRemoteDataSource(
    private val api: Api
) : BillDataSource.Remote {

    override fun checkout(checkoutBody: CheckoutBody): Single<Bill> = api.checkout(checkoutBody)
}
