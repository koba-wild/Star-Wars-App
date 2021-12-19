package com.example.starwars.db

import android.content.Context
import androidx.room.Room
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.starwars.data.detailHero.Hero

@Database(entities = [Hero::class], version = 3_2,  exportSchema = true)
@TypeConverters(TypeConverter::class)

abstract class HeroesDatabase : RoomDatabase() {
    abstract fun heroDao() : HeroDao

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
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}