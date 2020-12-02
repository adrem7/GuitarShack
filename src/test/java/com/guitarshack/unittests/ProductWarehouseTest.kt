package com.guitarshack.unittests

import main.Network
import main.Product
import com.guitarshack.ProductWarehouse
import org.junit.Test
import retrofit2.Call
import kotlin.test.assertEquals

class ProductWarehouseTest {

    @Test
    fun `fetch product by id`() {
        val productWarehouse = ProductWarehouse(ProductNetworkStub())
        val productId = 811

        val returnedProduct = productWarehouse.fetchProduct(productId)

        assertEquals(811, returnedProduct.productId)
    }
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