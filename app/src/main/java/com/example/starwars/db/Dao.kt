package com.example.starwars.db

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.starwars.data.Hero

interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllHeroes(heroes: List<Hero>)

    @Query("DELETE from heroes_names")
    fun clear()

    @Query("SELECT * FROM heroes_names ORDER BY uid ASC")
    fun getAllHeroes(): LiveData<List<Hero>>

    @Query("UPDATE heroes_names SET favorite =:favorite  WHERE uid = :uid")
    fun updateFavorite(uid: String, favorite: Boolean)

    @Query("SELECT * FROM heroes_names WHERE favorite ORDER BY uid DESC")
    fun getAllFavorite(): LiveData<List<Hero>>
}