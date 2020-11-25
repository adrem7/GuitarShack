package com.guitarshack.contracttests

import main.GuitarShackSalesData
import main.HttpNetwork
import com.guitarshack.unittests.SalesDataTestBase

class SalesDataTest : SalesDataTestBase() {

    override fun guitarShackSalesData() = GuitarShackSalesData(HttpNetwork())
}