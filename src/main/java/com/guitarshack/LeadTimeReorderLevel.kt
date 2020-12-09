package com.guitarshack

import com.guitarshack.HistoricalDate.Companion.calculateDate
import java.util.*

class LeadTimeReorderLevel(
    private val salesData: SalesData,
    private val currentDate: CurrentDate
) : ReorderLevel {

    override fun get(product: Product): Int {
        var total = 0
        var startDate = calculateDate(currentDate.get(), Calendar.YEAR, -1)
        val endDate = calculateDate(startDate, Calendar.DATE, product.leadTime - 1)
        total = salesData.salesTotal(product.id, startDate, endDate)
        if (total == 0 ) {
            startDate = calculateDate(currentDate.get(), Calendar.DATE, -(product.leadTime - 1))
            total = salesData.salesTotal(product.id, startDate, currentDate.get())
        }
        return total
    }
}
