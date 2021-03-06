package com.guitarshack

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SalesDataService {
    @GET("sales?")
    fun getSalesTotal(
        @Query("id") productId: Int,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String,
        @Query("action") action: String
    ) : Call<Sales>
}
