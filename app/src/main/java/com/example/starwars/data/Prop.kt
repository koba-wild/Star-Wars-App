package com.example.starwars.data

import com.google.gson.annotations.SerializedName

data class Prop (@SerializedName("properties") val hero: Hero)