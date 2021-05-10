package com.sun.dummyshop.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sun.dummyshop.data.model.CartItem
import java.io.Serializable

class CartItemTypeConverter : Serializable {

    @TypeConverter
    fun cartItemsToJson(cartItems: List<CartItem>): String {
        val type = object : TypeToken<List<CartItem>>() {}.type
        return Gson().toJson(cartItems, type)
    }

    @TypeConverter
    fun jsonToCartItems(json: String): List<CartItem> {
        val type = object : TypeToken<List<CartItem>>() {}.type
        return Gson().fromJson(json, type)
    }
}
