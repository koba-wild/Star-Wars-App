package com.example.starwars.data

import com.google.gson.annotations.SerializedName

data class Heroes ( @SerializedName("results") val heroes: List<HeroTitle>)
