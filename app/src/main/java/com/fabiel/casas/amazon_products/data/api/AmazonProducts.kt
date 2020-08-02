package com.fabiel.casas.amazon_products.data.api

import com.fabiel.casas.amazon_products.data.models.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AmazonProducts {

    @GET("ios-assignment/search?query=apple&page=1")
    fun listAmazonProducts(
        @Query("query") query: String,
        @Query("page") page: String = "1"
    ): Call<ProductsResponse>
}