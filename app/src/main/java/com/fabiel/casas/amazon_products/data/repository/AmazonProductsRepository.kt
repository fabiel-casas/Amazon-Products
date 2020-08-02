package com.fabiel.casas.amazon_products.data.repository

import com.fabiel.casas.amazon_products.data.config.ApiResult
import com.fabiel.casas.amazon_products.data.models.Product

interface AmazonProductsRepository {
    suspend fun getAmazonProducts(search: String): ApiResult<List<Product>>
}