package com.example.starwars.data.heroTitle

import com.google.gson.annotations.SerializedName

data class HeroTitle (
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
    @SerializedName("uid") val uid: String
    )