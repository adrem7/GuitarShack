package com.guitarshack.unittests

import com.guitarshack.GuitarShackSalesData
import com.guitarshack.Network
import com.guitarshack.Sales
import retrofit2.Call

class SalesDataUnitTest : SalesDataTestBase() {
    override fun guitarShackSalesData(): GuitarShackSalesData {
        return GuitarShackSalesData(NetworkStub())
    }

}

class NetworkStub : Network {
    override fun <T> executeCall(call: Call<T>): T {
        return Sales(31) as T
    }
}
