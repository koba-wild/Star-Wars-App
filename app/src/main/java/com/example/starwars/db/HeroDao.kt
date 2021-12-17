package com.example.starwars.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.starwars.data.HeroTitle

@Dao
interface HeroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllHeroes(heroes: List<HeroTitle>)

    @Query("DELETE from heroes")
    fun clear()

    @Query("SELECT * FROM heroes ORDER BY uid ASC")
    fun getAllHeroes(): LiveData<List<HeroTitle>>

    @Query("UPDATE heroes SET favourites =:favorite  WHERE uid = :uid")
    fun updateFavorite(uid: String, favorite: Boolean)

    @Query("SELECT * FROM heroes WHERE favourites ORDER BY uid DESC")
    fun getAllFavorite(): LiveData<List<HeroTitle>>
}