package test.contracttests

import main.GuitarShackSalesData
import main.HttpNetwork
import test.unittests.SalesDataTestBase

class SalesDataTest : SalesDataTestBase() {

    override fun guitarShackSalesData() = GuitarShackSalesData(HttpNetwork())
}