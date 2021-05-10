package com.sun.dummyshop.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "bill")
data class Bill(
    @PrimaryKey
    @SerializedName("date")
    @ColumnInfo(name = "date")
    val date: String,
    @SerializedName("totalItems")
    @ColumnInfo(name = "totalItems")
    val totalItems: Int,
    @SerializedName("totalAmount")
    @ColumnInfo(name = "totalAmount")
    val totalAmount: Int,
    @SerializedName("itemsBought")
    @ColumnInfo(name = "itemsBought")
    val itemsBought: List<CartItem>?,
)
