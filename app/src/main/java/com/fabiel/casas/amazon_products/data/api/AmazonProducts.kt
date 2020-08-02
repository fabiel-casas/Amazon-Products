package com.fabiel.casas.amazon_products.data.api

import com.fabiel.casas.amazon_products.data.models.Product
import com.fabiel.casas.amazon_products.data.models.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET

interface AmazonProducts {

    @GET("ios-assignment/search")
    fun listAmazonProducts(): Call<ProductsResponse>
}