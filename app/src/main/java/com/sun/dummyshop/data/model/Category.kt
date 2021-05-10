package com.sun.dummyshop.data.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("department_id")
    val id: String,
    @SerializedName("department_name")
    val name: String
)
