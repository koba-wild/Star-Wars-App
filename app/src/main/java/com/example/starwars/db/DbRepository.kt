package com.example.starwars.db

import com.example.starwars.data.Hero
import com.example.starwars.data.HeroTitle
import com.example.starwars.data.Heroes
import com.example.starwars.data.ResultHero
import com.example.starwars.network.StarWarsApiService

class DbRepository (private val dao: HeroDao, private val starWarsApiService: StarWarsApiService) {


    suspend fun getRemoteHeroes(): Heroes {
        return starWarsApiService.getHeroes()
    }

    suspend fun getRemoteHero(uid: String): ResultHero {
        return starWarsApiService.getHero(uid)
    }

    fun getAllHeroes() = dao.getAllHeroes()

    suspend fun getAllFavorite() = dao.getAllFavorite()

    suspend fun addAllHeroes(heroes: List<HeroTitle>) = dao.addAllHeroes(heroes)

    suspend fun updateFavorite(uid: String, favorite: Boolean) = dao.updateFavorite(uid, favorite)

    fun clear() = dao.clear()

}