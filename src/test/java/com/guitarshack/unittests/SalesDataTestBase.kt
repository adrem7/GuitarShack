package com.guitarshack.unittests

import com.guitarshack.GuitarShackSalesData
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

abstract class SalesDataTestBase {
    @Test
    fun `given a range of dates calculate the number of sales`() {
        val salesData = guitarShackSalesData()

        assertEquals(31, salesData.salesTotal(811,
            Date(2019-1900, 6, 17),
            Date(2019-1900,6,27)))
    }

    protected abstract fun guitarShackSalesData(): GuitarShackSalesData
}