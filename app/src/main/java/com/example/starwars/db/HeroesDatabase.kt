package com.example.starwars.db

import android.content.Context
import androidx.room.Room
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.starwars.data.Hero

@Database(entities = [Hero::class], version = 1,  exportSchema = true)
@TypeConverters(TypeConverter::class)

abstract class HeroesDatabase : RoomDatabase() {
    abstract fun dao() : Dao

    companion object {
        @Volatile
        private var INSTANCE: HeroesDatabase? = null

        fun getInstance(
            context: Context
        ): HeroesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HeroesDatabase::class.java,
                    "heroes_database"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}