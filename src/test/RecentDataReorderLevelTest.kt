package test

import io.mockk.every
import io.mockk.mockk
import io.mockk.verifySequence
import main.*
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import java.util.*

class RecentDataReorderLevelTest {

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
        every { salesData.salesTotal(any(), any(), any()) } returnsMany listOf(0, 25)
    }

    @Ignore
    @Test
    fun `reorderLevel calculated from recent start date`() {
        val startDate = Date(2020, 9, 1)

        reorderLevel.get(product)

        verifySequence {
            salesData.salesTotal(any(), any(), any())
            salesData.salesTotal(811, startDate, any())
        }
    }

}