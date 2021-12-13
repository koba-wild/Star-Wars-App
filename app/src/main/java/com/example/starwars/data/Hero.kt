package com.example.starwars.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "heroes_names")
@Parcelize
data class Hero (
    @SerializedName("uid") @PrimaryKey val uid: String,
    @SerializedName("name") val name: String,
    @SerializedName("birth_year") val birthYear: String,
    @SerializedName("eye_color") val eyeColor: String,
    @SerializedName("gender ") val gender: String,
    @SerializedName("hair_color") val hairColor: String,
    @SerializedName("height") val height: String,
    @SerializedName("mass") val mass: String,
    @SerializedName("skin_color") val skinColor: String,
    @SerializedName("homeworld") val homeworld: String,
    @SerializedName("films") val films: String,
    @SerializedName("species") val species: ArrayList<String>,
    @SerializedName("starships") val starships: ArrayList<String>,
    @SerializedName("vehicles") val vehicles: ArrayList<String>,
    @SerializedName("description") val description: String,
    val favorite: Boolean = false
        ) : Parcelable
