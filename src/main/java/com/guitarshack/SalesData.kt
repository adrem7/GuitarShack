package com.guitarshack

import java.util.*

interface SalesData {
    fun salesTotal(productId: Int, startDate: Date, endDate: Date): Int
}
