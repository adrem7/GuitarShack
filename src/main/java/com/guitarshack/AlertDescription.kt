package main

class AlertDescription(private val product: Product) {
    fun build(): String {
        return "You need to reorder product ${product.id} -  " +
                "Make: ${product.make}, " +
                "Range: ${product.range}, " +
                "Model: ${product.model}, " +
                "Description: ${product.description}, " +
                "Rack Space: ${product.rackspace}, " +
                "Minimum Order: ${product.minOrder}"
    }
}