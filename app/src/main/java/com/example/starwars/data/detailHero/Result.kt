package com.example.starwars.data.detailHero

import com.google.gson.annotations.SerializedName

data class Result (
    @SerializedName("properties") val hero : Hero,
    @SerializedName("description") val description : String,
    @SerializedName("_id") val _id : String,
    @SerializedName("uid") val uid : String,
    @SerializedName("__v") val __v : Int
)