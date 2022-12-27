package com.example.ejercicio2_starwars_hgaj.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants{
    const val BASE_URL = "https://swapi.dev/"
    const val LOGTAG= "LOGS"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}