package com.fabiel.casas.amazon_products.data.config

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun <T : Any> Call<T>.executeAsSuspended(): ApiResult<T> =
    suspendCoroutine { cont ->

        val callback = object : Callback<T>{
            override fun onFailure(call: Call<T>, t: Throwable) {
                cont.resume(ApiResult.Error(Exception(t.message)))
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                cont.resume(ApiResult.Success<T>(response.body()!!))
            }

        }
        enqueue(callback)
    }