package com.example.starwars.network

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

object Retrofit {

    const val BASE_URL = "https://www.swapi.tech/api/"

    fun buildRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun buildApiService(): StarWarsApiService =
        buildRetrofit().create(StarWarsApiService::class.java)
}