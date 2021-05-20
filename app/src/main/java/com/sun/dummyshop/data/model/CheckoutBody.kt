package com.sun.dummyshop.data.model

import com.google.gson.annotations.SerializedName

data class CheckoutBody(
    @SerializedName("items")
    val products: List<CartProduct>
)
