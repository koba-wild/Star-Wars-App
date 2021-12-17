package com.example.starwars.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "heroes")
@Parcelize
data class HeroTitle (
    @SerializedName("uid") @PrimaryKey val uid: String,
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
    val favourites: Boolean = false
    ) : Parcelable