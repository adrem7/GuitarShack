package com.guitarshack.unittests

import main.GuitarShackSalesData
import main.Network
import main.Sales
import retrofit2.Call

class SalesDataUnitTest : SalesDataTestBase() {
    override fun guitarShackSalesData(): GuitarShackSalesData {
        return GuitarShackSalesData(NetworkStub())
    }

}

class NetworkStub : Network {
    override fun executeCall(call: Call<Sales>): Int {
        return 31
    }
}
