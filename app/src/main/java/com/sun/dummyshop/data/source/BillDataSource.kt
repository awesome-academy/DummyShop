package com.sun.dummyshop.data.source

import com.sun.dummyshop.data.model.Bill
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface BillDataSource {
    interface Local {
        fun getBills(): Observable<List<Bill>>
        fun insertBill(bill: Bill): Completable
    }
}
