package com.fabiel.casas.amazon_products.usecases

import com.fabiel.casas.amazon_products.data.config.ApiResult
import com.fabiel.casas.amazon_products.data.models.Product
import com.fabiel.casas.amazon_products.data.repository.AmazonProductsRepository

class AmazonProductsUseCaseImpl(
    private val repository: AmazonProductsRepository
) : AmazonProductsUseCase {
    override suspend fun invoke(): ApiResult<List<Product>> {
        return repository.getAmazonProducts()
    }
}