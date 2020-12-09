package com.guitarshack

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductWarehouse(private val network: Network): Warehouse {
    override fun fetchProduct(productId: Int): Product {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://6hr1390c1j.execute-api.us-east-2.amazonaws.com/default/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ProductDataService::class.java)
        val call = service.getProduct(productId)

        return network.executeCall<Product>(call)
    }
}
