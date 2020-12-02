package com.guitarshack.unittests

import com.guitarshack.ProductWarehouse
import junit.framework.Assert.assertEquals
import org.junit.Test

abstract class ProductWarehouseBaseTest {
    @Test
    fun `fetch product by id`() {
        val productWarehouse = productWarehouse()
        val productId = 811

        val returnedProduct = productWarehouse.fetchProduct(productId)

        assertEquals(811, returnedProduct.id)
    }

    protected abstract fun productWarehouse(): ProductWarehouse
}