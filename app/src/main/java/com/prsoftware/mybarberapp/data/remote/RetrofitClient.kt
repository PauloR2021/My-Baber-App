/*
* Object: Responsável por ter a chamada dos EndPoint da API para dentro do APP com o Retrofit
*
* Author:Paulo Ricardo
*/


package com.prsoftware.mybarberapp.data.remote
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // No Android o Local Host é igual : 10.0.2.2
    private const val BASE_URL =
        "http://10.0.2.2:8085/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(ApiService::class.java)
    }
}