package com.example.starwars.data

import com.google.gson.annotations.SerializedName

data class Hero (
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
    @SerializedName("birth_year") val birthYear: String?,
    @SerializedName("eye_color") val eyeColor: String?,
    @SerializedName("gender ") val gender: String?,
    @SerializedName("hair_color") val hairColor: String?,
    @SerializedName("height") val height: String?,
    @SerializedName("mass") val mass: String?,
    @SerializedName("skin_color") val skinColor: String?,
    @SerializedName("homeworld") val homeworld: String?,
    @SerializedName("films") val films: String?,
    @SerializedName("species") val species: ArrayList<String>?,
    @SerializedName("starships") val starships: ArrayList<String>?,
    @SerializedName("vehicles") val vehicles: ArrayList<String>?
        )
