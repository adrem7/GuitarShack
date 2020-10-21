package main

class AlertDescription(private val product: Product) {
    fun build(): String {
        return "You need to reorder product ${product.productId} -  " +
                "Make: ${product.make}, " +
                "Range: ${product.range}, " +
                "Model: ${product.model}, " +
                "Description: ${product.description}, " +
                "Rack Space: ${product.rackSpace}, " +
                "Minimum Order: ${product.minOrder}"
    }
}