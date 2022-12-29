package com.example.ejercicio2_starwars_hgaj.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface starApi {

    @GET("api/people/")
    fun personaje(): Call<starPersona>

    @GET("api/people/{num}/")
    fun personajeDetail(@Path("num") num: Int): Call<starDetail>

    @GET("api/planets/")
    fun planeta(): Call<starPlaneta>

    @GET("api/planets/{num2}/")
    fun planetaDetail(@Path("num2") num: Int): Call<starPlanetaDetail>






/*@GET
    fun getstar(
        @Url url: String?
    ): Call<ArrayList<star>>

    @GET("api/people/")
    fun getstarDetail(@Path("count") count: Int?
    ): Call<ArrayList<starDetail>>*/
}