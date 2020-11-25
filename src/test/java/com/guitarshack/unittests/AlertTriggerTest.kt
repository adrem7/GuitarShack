package com.guitarshack.unittests

import io.mockk.mockk
import io.mockk.verify
import main.AlertTrigger
import main.Product
import main.Reorder
import main.Warehouse
import org.junit.Test

class AlertTriggerTest {

    @Test
    fun `given product id and quantity we trigger product sold with correct product details`() {
        val reorder = mockk<Reorder>(relaxed = true)
        val product = Product(811, 2, "", "", "", "", 10, 3, 5)
        val warehouse = WarehouseStub(product)
        val alertTrigger = AlertTrigger(warehouse, reorder)

        alertTrigger.triggerSale(811, 3)

        verify { reorder.productSold(product, 3) }
    }
}

class WarehouseStub (val product: Product) : Warehouse {
    override fun fetchProduct(productid: Int): Product {
        return product
    }
}
