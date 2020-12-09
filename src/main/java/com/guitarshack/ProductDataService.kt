package com.guitarshack

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductDataService {
    @GET("product?")
    fun getProduct(
        @Query("id") productId: Int
    ): Call<Product>
}
