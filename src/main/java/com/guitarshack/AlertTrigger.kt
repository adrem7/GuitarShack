package com.guitarshack

class AlertTrigger(
    val warehouse: Warehouse,
    val reorder: Reorder
) {

    fun triggerSale(productId: Int, quantity: Int) {
        val product = warehouse.fetchProduct(productId)
        reorder.productSold(product, quantity)
    }
}
