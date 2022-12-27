package com.example.ejercicio2_starwars_hgaj.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface starApi {

    @GET("api/people/")
    fun personaje(): Call<starPersona>

    @GET("api/people/{num}/")
    fun personajeDetail(@Path("num") num: String?): Call<starDetail>






/*@GET
    fun getstar(
        @Url url: String?
    ): Call<ArrayList<star>>

    @GET("api/people/")
    fun getstarDetail(@Path("count") count: Int?
    ): Call<ArrayList<starDetail>>*/
}