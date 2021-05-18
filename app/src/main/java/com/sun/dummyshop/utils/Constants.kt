package com.sun.dummyshop.utils

object Constants {
    const val BASE_URL = "https://dummyproducts-api.herokuapp.com/api/v1/"
    const val API = "apikey"
    const val SIMILARITIES_VALUE = "true"
    const val FILTER_GREATER_EQUAL = "gte_"
    const val FILTER_LESS_EQUAL = "^lte_"
    const val FILTER_MAX_RATING = "5"

    const val ITEM_QUANTITY = 4
    const val PRODUCT_QUANTITY_UNIT = 1
    const val PRODUCT_IS_FAVORITE = 1
    const val PRODUCT_NOT_FAVORITE = 0
    const val EXCEPTION_EMPTY_RESULT = "Query returned empty result set: SELECT * FROM product WHERE id = ?"
    const val EXCEPTION_EMPTY_SEARCH_RESULT = "HTTP 404 Not Found"
    const val TOP_POSITION = 0
}
