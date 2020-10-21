package main

import java.util.*

class HistoricalDate {
    companion object {
        fun calculateDate(from: Date, dateComponent: Int, amount: Int): Date {
            val calendar = Calendar.getInstance()
            calendar.time = from
            calendar.add(dateComponent, amount)
            return calendar.time
        }
    }
}