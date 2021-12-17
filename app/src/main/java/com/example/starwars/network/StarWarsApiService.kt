package com.example.starwars.network

import com.example.starwars.data.Hero
import com.example.starwars.data.HeroTitle
import com.example.starwars.data.Heroes
import com.example.starwars.data.ResultHero
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsApiService {

    @GET("people/")
    suspend fun getHeroes(): Heroes

    @GET("people/{characterUid}")
    suspend fun getHero(@Path("characterUid") characterUid: String): ResultHero
}