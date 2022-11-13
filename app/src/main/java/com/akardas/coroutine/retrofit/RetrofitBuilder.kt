package com.akardas.coroutine.retrofit

import com.akardas.coroutine.networking.ApiEndpoints
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://reqres.in/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter
    }

    val apiService: ApiEndpoints = getRetrofit().create(ApiEndpoints::class.java)
}