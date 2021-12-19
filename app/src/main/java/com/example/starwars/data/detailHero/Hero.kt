package com.example.starwars.data.detailHero

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "heroes")
@Parcelize
data class Hero (
    @SerializedName("height") val height : Int,
    @SerializedName("mass") val mass : Int,
    @SerializedName("hair_color") val hair_color : String,
    @SerializedName("skin_color") val skin_color : String,
    @SerializedName("eye_color") val eye_color : String,
    @SerializedName("birth_year") val birth_year : String,
    @SerializedName("gender") val gender : String,
    @SerializedName("created") val created : String,
    @SerializedName("edited") val edited : String,
    @SerializedName("name") val name : String,
    @SerializedName("homeworld") val homeworld : String,
    @SerializedName("url") val url : String,
    val favourites: Boolean = false,
    @PrimaryKey var uid: Int
        ) : Parcelable
