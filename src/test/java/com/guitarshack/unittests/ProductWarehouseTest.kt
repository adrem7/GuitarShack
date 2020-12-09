package com.guitarshack.unittests

import com.guitarshack.Network
import com.guitarshack.Product
import com.guitarshack.ProductWarehouse
import retrofit2.Call

class ProductWarehouseTest : ProductWarehouseBaseTest() {
    override fun productWarehouse() = ProductWarehouse(ProductNetworkStub())

}

class ProductNetworkStub: Network {
    override fun <T> executeCall(call: Call<T>): T {
        return Product(
            811,
            0,
            "",
            "",
            "",
            "",
            0,
            0,
            0
        ) as T
    }
}