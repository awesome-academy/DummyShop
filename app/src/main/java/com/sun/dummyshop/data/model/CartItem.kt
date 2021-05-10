package com.sun.dummyshop.data.model

import com.google.gson.annotations.SerializedName

data class CartItem(
    @SerializedName("_id")
    val id: String,
    @SerializedName("product_name")
    val name: String,
    @SerializedName("product_price")
    val price: String,
    @SerializedName("product_quantity")
    val quantity: Int,
    @SerializedName("product_image_lg")
    val image: String,
)
