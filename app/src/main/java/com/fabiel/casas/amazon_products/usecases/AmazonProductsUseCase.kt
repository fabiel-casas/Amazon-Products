package com.fabiel.casas.amazon_products.usecases

import com.fabiel.casas.amazon_products.data.config.ApiResult
import com.fabiel.casas.amazon_products.data.models.Product

interface AmazonProductsUseCase {
    suspend fun invoke(): ApiResult<List<Product>>
}