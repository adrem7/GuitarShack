package com.guitarshack.unittests

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import main.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*


class HistoricalDataReorderLevelTest {

    private val salesData = mockk<SalesData>()
    private val product = Product(
        811,
        1,
        "",
        "",
        "",
        "",
        1,
        1,
        14
    )

    private val currentDateStub = object : CurrentDate {
        override fun get(): Date {
            return Date(2020, 9, 14)
        }
    }

    private val reorderLevel: ReorderLevel = LeadTimeReorderLevel(salesData, currentDateStub)

    @Before
    fun setup() {
        every { salesData.salesTotal(any(), any(), any()) } returns 14
    }

    @Test
    fun `reorderLevel calculated from past sales data`() {
        assertEquals(14, reorderLevel.get(product))
    }

    @Test
    fun `reorderLevel calculated from correct past start date`() {
        val startDate = Date(2019, 9, 14)

        reorderLevel.get(product)

        verify { salesData.salesTotal(811, startDate, any()) }
    }

    @Test
    fun `reorderLevel calculated to correct past end date`() {
        val endDate = Date(2019, 9, 27)

        reorderLevel.get(product)

        verify { salesData.salesTotal(811, any(), endDate) }
    }

}