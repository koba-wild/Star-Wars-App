package com.example.starwars.data.detailHero

import com.google.gson.annotations.SerializedName

data class Base (
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : Result
)


