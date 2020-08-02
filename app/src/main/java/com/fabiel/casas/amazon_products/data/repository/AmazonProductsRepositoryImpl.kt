package com.fabiel.casas.amazon_products.data.repository

import com.fabiel.casas.amazon_products.data.api.AmazonProducts
import com.fabiel.casas.amazon_products.data.config.ApiResult
import com.fabiel.casas.amazon_products.data.config.RetrofitServiceBuilder
import com.fabiel.casas.amazon_products.data.config.executeAsSuspended
import com.fabiel.casas.amazon_products.data.models.Product
import java.lang.Exception

class AmazonProductsRepositoryImpl : AmazonProductsRepository {
    private val repository = RetrofitServiceBuilder.buildService(AmazonProducts::class.java)
    override suspend fun getAmazonProducts(search: String): ApiResult<List<Product>> {
        val result = repository.listAmazonProducts(search).executeAsSuspended()
        return when(result) {
            is ApiResult.Success -> ApiResult.Success(result.data.products)
            else -> ApiResult.Error(Exception())
        }
    }
}