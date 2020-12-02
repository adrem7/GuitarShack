package main

class Reorder(private val alertMessenger: AlertMessenger, private val reorderLevel: ReorderLevel) {

    fun productSold(product: Product, quantity: Int) {
        val stockAfterSale = product.stock - quantity
        val alreadyAlerted = product.stock <= reorderLevel.get(product)
        val reorderLevelReached = stockAfterSale <= reorderLevel.get(product)

        if (reorderLevelReached && !alreadyAlerted)
            alertMessenger.sendAlert(
                AlertDescription(product).build()
            )
    }
}
