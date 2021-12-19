package com.example.starwars.db

import com.example.starwars.data.detailHero.Hero
import com.example.starwars.data.heroTitle.Heroes
import com.example.starwars.data.detailHero.Base
import com.example.starwars.network.StarWarsApiService

class DbRepository (private val dao: HeroDao, private val starWarsApiService: StarWarsApiService) {


    suspend fun getRemoteHeroes(): Heroes {
        return starWarsApiService.getHeroes()
    }

    suspend fun getRemoteHero(uid: Int): Base {
        return starWarsApiService.getHero(uid)
    }

    fun getAllHeroes() = dao.getAllHeroes()

    suspend fun getAllFavorite() = dao.getAllFavorite()

    suspend fun addAllHeroes(heroes: List<Hero>) = dao.addAllHeroes(heroes)

    suspend fun updateFavorite(uid: Int, favorite: Boolean) = dao.updateFavorite(uid, favorite)

    fun clear() = dao.clear()

}