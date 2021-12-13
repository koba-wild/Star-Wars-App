package com.example.starwars.network

import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsApiService {
    @GET("{characterId}")
    suspend fun getRockets(@Path("characterId") characterId: Int): List<Character>
}