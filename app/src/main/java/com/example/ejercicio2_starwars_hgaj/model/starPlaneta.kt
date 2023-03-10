package com.example.ejercicio2_starwars_hgaj.model

import com.google.gson.annotations.SerializedName

data class starPlaneta(
    val count: Int,
    val results: ArrayList<resultsplaneta>
)

class resultsplaneta(
   // @SerializedName("namePlanet")
    val name: String,
    val rotation_period: String,
    val orbital_period: String,
    val diameter: String,
    val climate: String,
    val terrain: String,
    val population: String

)
