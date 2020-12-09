package com.guitarshack.unittests

import io.mockk.*
import com.guitarshack.AlertMessenger
import com.guitarshack.Product
import com.guitarshack.Reorder
import com.guitarshack.ReorderLevel
import org.junit.Test

class ReorderTest {
    private val alertMessenger = mockk<AlertMessenger>(relaxed = true)

    @Test
    fun `sale triggers reorder level`() {
        val reorder = Reorder(alertMessenger, ReorderLevelStub(14))
        val product = buildProductWithStock(15)

        reorder.productSold(product, 1)

        verify { alertMessenger.sendAlert(any()) }
    }

    @Test
    fun `alert triggering reorder text is correct`() {
        val product = Product(
            811,
            15,
            "Epiphone",
            "Les Paul",
            "Les Paul Classic",
            "Epiphone Les Paul Classic In Worn Heritage Cherry Sunburst",
            30,
            20,
            1
        )
        val reorder = Reorder(alertMessenger, ReorderLevelStub(14))

        reorder.productSold(product, 1)

        verify {
            alertMessenger.sendAlert(
                "You need to reorder product 811 -  " +
                        "Make: Epiphone, " +
                        "Range: Les Paul, " +
                        "Model: Les Paul Classic, " +
                        "Description: Epiphone Les Paul Classic In Worn Heritage Cherry Sunburst, " +
                        "Rack Space: 30, " +
                        "Minimum Order: 20"
            )
        }
    }

    @Test
    fun `sale does not trigger reorder level - remaining stock above reorder level`() {
        val reorder = Reorder(alertMessenger, ReorderLevelStub(14))
        val product = buildProductWithStock(16)

        reorder.productSold(product, 1)

        verify(exactly = 0) { alertMessenger.sendAlert(any()) }
    }

    @Test
    fun `sale does not trigger reorder level - alert has already been triggered`() {
        val reorder = Reorder(alertMessenger, ReorderLevelStub(14))
        val product = buildProductWithStock(13)

        reorder.productSold(product, 1)

        verify(exactly = 0) { alertMessenger.sendAlert(any()) }
    }


    private fun buildProductWithStock(stockLevel: Int): Product {
        val productId = 811
        val minOrder = 20
        val rackSpace = 30
        val description = ""
        val model = ""
        val make = ""
        val range = ""
        val leadTime = 1

        return Product(productId, stockLevel, make, range, model, description, rackSpace, minOrder, leadTime)
    }

    data class ReorderLevelStub(val reorderLevel: Int) : ReorderLevel {
        override fun get(product: Product): Int {
            return reorderLevel
        }
    }
}

