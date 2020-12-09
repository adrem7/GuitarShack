package com.guitarshack.contracttests

import com.guitarshack.GuitarShackSalesData
import com.guitarshack.HttpNetwork
import com.guitarshack.unittests.SalesDataTestBase

class SalesDataTest : SalesDataTestBase() {

    override fun guitarShackSalesData() = GuitarShackSalesData(HttpNetwork())
}