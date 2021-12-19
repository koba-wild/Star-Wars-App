package com.example.starwars.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.starwars.data.detailHero.Hero

@Dao
interface HeroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllHeroes(heroes: List<Hero>)

    @Query("DELETE from heroes")
    fun clear()

    @Query("SELECT * FROM heroes")
    fun getAllHeroes(): LiveData<List<Hero>>

    @Query("UPDATE heroes SET favourites =:favourites  WHERE uid = :uid")
    fun updateFavorite(uid: Int, favourites: Boolean)

    @Query("SELECT * FROM heroes WHERE favourites ORDER BY uid DESC")
    fun getAllFavorite(): LiveData<List<Hero>>
}