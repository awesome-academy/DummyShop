package com.sun.dummyshop.data.repository

import com.sun.dummyshop.data.model.Bill
import com.sun.dummyshop.data.source.BillDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

class BillRepositoryImpl(
    private val local: BillDataSource.Local
) : BillRepository {

    override fun getBills(): Observable<List<Bill>> = local.getBills()

    override fun insertBill(bill: Bill): Completable = local.insertBill(bill)
}
