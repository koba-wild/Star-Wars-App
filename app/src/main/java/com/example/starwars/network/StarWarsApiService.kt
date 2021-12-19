package com.example.starwars.network

import com.example.starwars.data.detailHero.Base
import com.example.starwars.data.heroTitle.Heroes
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsApiService {

    @GET("people/")
    suspend fun getHeroes(): Heroes

    @GET("people/{characterUid}")
    suspend fun getHero(@Path("characterUid") uid: Int): Base
}