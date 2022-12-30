package com.example.ejercicio2_starwars_hgaj.model

import com.google.gson.annotations.SerializedName

data class starPeliculaDetail (
     @SerializedName("title")
     var title: String?=null

)
