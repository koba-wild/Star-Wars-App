package com.example.starwars.db

import android.app.Application
import com.example.starwars.network.Retrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


class StarWarsApplication : Application() {
    private val applicationScope = CoroutineScope(Dispatchers.Default)
    val database by lazy { HeroesDatabase.getInstance(this) }
    val repository by lazy { DbRepository(database.dao(), Retrofit.buildApiService()) }
}