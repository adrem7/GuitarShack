package main

class Reorder(private val alertMessenger: AlertMessenger, private val reorderLevel: ReorderLevel) {

    fun productSold(product: Product, quantity: Int) {
        val stockAfterSale = product.stockLevel - quantity
        val alreadyAlerted = product.stockLevel <= reorderLevel.get(product)
        val reorderLevelReached = stockAfterSale <= reorderLevel.get(product)

        if (reorderLevelReached && !alreadyAlerted)
            alertMessenger.sendAlert(
                AlertDescription(product).build()
            )
    }
}
