package com.example.ejercicio2_starwars_hgaj.model

import com.google.gson.annotations.SerializedName

data class star(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("height")
    var height: String?= null,
    @SerializedName("birth_year")
    var birth_year: String?= null,
    @SerializedName("gender")
    var gender:String? = null

)
