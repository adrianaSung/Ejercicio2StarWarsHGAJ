package com.example.ejercicio2_starwars_hgaj.model

import com.google.gson.annotations.SerializedName

data class starPersona(
    val count: Int,
    val results: ArrayList<results>
)

class results(
    val name: String,
    val height: String,
    val birth_year: String,
    val gender: String,

)
