package main

import java.util.*

class LeadTimeReorderLevel(
    private val salesData: SalesData,
    private val currentDate: CurrentDate
) : ReorderLevel {

    override fun get(product: Product): Int {
        val calendar = Calendar.getInstance()
        calendar.time = currentDate.get()
        calendar.add(Calendar.YEAR, -1)

        val startDate = calendar.time

        calendar.add(Calendar.DATE, product.leadTime - 1)

        val endDate = calendar.time

        return salesData.salesTotal(product.productId, startDate, endDate)
    }
}

