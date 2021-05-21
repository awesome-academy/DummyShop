package com.sun.dummyshop.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.dummyshop.base.BaseViewModel
import com.sun.dummyshop.data.model.Product
import com.sun.dummyshop.data.repository.ProductRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class FavoriteViewModel(
    private val repository: ProductRepository
) : BaseViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    init {
        getFavoriteProducts()
    }

    private fun getFavoriteProducts() {
        repository.getFavoriteProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _products.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposable)
    }
}
