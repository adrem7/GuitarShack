package com.guitarshack

import main.Product

interface Warehouse {

    fun fetchProduct(productid: Int): Product
}
