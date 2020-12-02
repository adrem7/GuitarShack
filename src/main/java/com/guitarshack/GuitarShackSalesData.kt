package main

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

class GuitarShackSalesData(
    private val network: Network
) : SalesData {

    override fun salesTotal(productId: Int, startDate: Date, endDate: Date): Int {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val datePattern = "M/d/YYYY"
        val simpleDateFormat = SimpleDateFormat(datePattern)

        val formattedStartDate = simpleDateFormat.format(startDate)
        val formattedEndDate = simpleDateFormat.format(endDate)

        val service = retrofit.create(SalesDataService::class.java)
        val call = service.getSalesTotal(productId, formattedStartDate, formattedEndDate, "total")
        return network.executeCall<Sales>(call).total
    }
}
