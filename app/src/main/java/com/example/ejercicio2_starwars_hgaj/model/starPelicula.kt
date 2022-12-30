package com.example.ejercicio2_starwars_hgaj.model

import com.google.gson.annotations.SerializedName

data class starPelicula(
    val count: Int,
    val results: ArrayList<resultspelicula>
)
class resultspelicula(
    // @SerializedName("namePlanet")
    val title: String


)

