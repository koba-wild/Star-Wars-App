package com.example.starwars.db

import android.app.Application
import com.example.starwars.network.Retrofit


class StarWarsApplication : Application() {
    val database by lazy { HeroesDatabase.getInstance(this) }
    val repository by lazy { DbRepository(database.heroDao(), Retrofit.buildApiService()) }
}