package com.example.ejercicio2_starwars_hgaj.util

import com.example.ejercicio2_starwars_hgaj.model.starDetail
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants{
    const val BASE_URL = "https://swapi.dev/"
    const val LOGTAG= "LOGS"

    val  listaPersonajes: HashMap<String, Int> = hashMapOf("Luke Skywalker" to 1, "C-3PO" to 2,
        "R2-D2" to 3,"Darth Vader" to 4,"Leia Organa" to 5,"Owen Lars" to 6,"Beru Whitesun lars" to 7,"R5-D4" to 8,
        "Biggs Darklighter" to 9,"Obi-Wan Kenobi" to 10)

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}