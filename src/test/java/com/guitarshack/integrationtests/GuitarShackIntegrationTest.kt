package com.guitarshack.integrationtests

import com.guitarshack.AlertTrigger
import com.guitarshack.ProductWarehouse
import io.mockk.*
import main.*
import org.junit.Test
import java.util.*

class GuitarShackIntegrationTest {

    @Test
    fun `given reorder level is reached then alert is triggered`(){
        val alertMessenger: AlertMessenger = mockk(relaxed = true)

        AlertTrigger(
            ProductWarehouse(HttpNetwork()),
            Reorder(
                alertMessenger,
                LeadTimeReorderLevel(
                    GuitarShackSalesData(HttpNetwork()),
                    object : CurrentDate {
                        override fun get(): Date {
                            val calendar: Calendar = Calendar.getInstance()
                            calendar.set(2020,7,1)
                            return calendar.time
                        }
                    }
                )
            )
        ).triggerSale(811, 1000)

        verify { alertMessenger.sendAlert(any()) }
    }
}