package com.example.starwars.network

import com.example.starwars.data.Hero
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsApiService {

    @GET("people/")
    suspend fun getHeroes(): List<Hero>

    @GET("people/{characterId}")
    suspend fun getHero(@Path("characterId") characterId: String?): Hero
}