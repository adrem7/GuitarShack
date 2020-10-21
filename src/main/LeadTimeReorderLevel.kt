package main

import main.HistoricalDate.Companion.calculateDate
import java.util.*

class LeadTimeReorderLevel(
    private val salesData: SalesData,
    private val currentDate: CurrentDate
) : ReorderLevel {

    override fun get(product: Product): Int {
        val startDate = calculateDate(currentDate.get(), Calendar.YEAR, -1)
        val endDate = calculateDate(startDate, Calendar.DATE, product.leadTime - 1)

        return salesData.salesTotal(product.productId, startDate, endDate)
    }
}
