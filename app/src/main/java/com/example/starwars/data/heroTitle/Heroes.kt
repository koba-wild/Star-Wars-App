package com.example.starwars.data.heroTitle

import com.google.gson.annotations.SerializedName

data class Heroes ( @SerializedName("results") val heroes: List<HeroTitle>)
