package com.fabiel.casas.amazon_products.data.config

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitServiceBuilder {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://bdk0sta2n0.execute-api.eu-west-1.amazonaws.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}
