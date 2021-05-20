package com.sun.dummyshop.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.dummyshop.base.BaseViewModel
import com.sun.dummyshop.data.model.Bill
import com.sun.dummyshop.data.model.CartProduct
import com.sun.dummyshop.data.model.CheckoutBody
import com.sun.dummyshop.data.model.Product
import com.sun.dummyshop.data.repository.BillRepository
import com.sun.dummyshop.data.repository.ProductRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class CartViewModel(
    private val productRepository: ProductRepository,
    private val billRepository: BillRepository
) : BaseViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    private val _bill = MutableLiveData<Bill>()
    val bill: LiveData<Bill>
        get() = _bill

    private val _total = MutableLiveData<Int>()
    val total: LiveData<Int>
        get() = _total

    private fun saveBill(bill: Bill) {
        billRepository.insertBill(bill)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposable)
    }

    private fun calculateAmount() {
        products.value?.let { list ->
            if (list.isNotEmpty())
                _total.value = list.map { it.price.toInt() * it.quantityInCart }
                    .reduce { sum, element -> sum + element }
        }
    }

    fun getProductsAddedToCart() {
        productRepository.getAddedToCartProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _products.value = it
                calculateAmount()
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposable)
    }

    fun checkout() {
        productRepository.getAddedToCartProducts()
            .map {
                it.map { product ->
                    CartProduct(product.id, product.quantityInCart.toString())
                }
            }
            .flatMap {
                val checkoutBody = CheckoutBody(it)
                billRepository.checkout(checkoutBody)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _bill.postValue(it)
                saveBill(it)
            }, {
                _error.postValue(it.message.toString())
            })
            .addTo(disposable)
    }
}
