package com.eosdev.yemenu.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import io.github.cdimascio.dotenv.dotenv


object RetrofitClient {
    private val dotenv = dotenv {
        directory = "./"
    }

    private val BASE_URL = dotenv["BASE_URL"]

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}