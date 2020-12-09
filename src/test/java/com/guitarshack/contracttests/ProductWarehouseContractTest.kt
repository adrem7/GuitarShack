package com.guitarshack.contracttests

import com.guitarshack.ProductWarehouse
import com.guitarshack.unittests.ProductWarehouseBaseTest
import com.guitarshack.HttpNetwork

class ProductWarehouseContractTest : ProductWarehouseBaseTest() {
    override fun productWarehouse(): ProductWarehouse {
        return ProductWarehouse(HttpNetwork())
    }
}