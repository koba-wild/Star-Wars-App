package com.example.starwars.db

import com.example.starwars.data.Hero
import com.example.starwars.network.StarWarsApiService

class DbRepository (private val dao: Dao, private val starWarsApiService: StarWarsApiService) {


    suspend fun getRemoteHeroes(): List<Hero> {
        return starWarsApiService.getHeroes()
    }

    suspend fun getRemoteHero(uid: String): Hero {
        return starWarsApiService.getHero(uid)
    }

    fun getAllHeroes() = dao.getAllHeroes()

    suspend fun getAllFavorite() = dao.getAllFavorite()

    suspend fun addAllHeroes(heroes: List<Hero>) = dao.addAllHeroes(heroes)

    suspend fun updateFavorite(uid: String, favorite: Boolean) = dao.updateFavorite(uid, favorite)

    fun clear() = dao.clear()

}