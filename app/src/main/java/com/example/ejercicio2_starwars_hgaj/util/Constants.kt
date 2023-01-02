package com.example.ejercicio2_starwars_hgaj.util

import com.example.ejercicio2_starwars_hgaj.model.starDetail
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants{
    const val BASE_URL = "https://swapi.dev/"
    const val BASE_URLIMAGE = "https://aulavirtual.amaurypm.com/"
    const val LOGTAG= "LOGS"

    val  listaPersonajes: HashMap<String, Int> = hashMapOf("Luke Skywalker" to 1, "C-3PO" to 2,
        "R2-D2" to 3,"Darth Vader" to 4,"Leia Organa" to 5,"Owen Lars" to 6,"Beru Whitesun lars" to 7,"R5-D4" to 8,
        "Biggs Darklighter" to 9,"Obi-Wan Kenobi" to 10)

    val listaPlanetas: HashMap<String,Int> = hashMapOf("Luke Skywalker" to 1, "C-3PO" to 1,
        "R2-D2" to 8,"Darth Vader" to 1,"Leia Organa" to 2,"Owen Lars" to 1,"Beru Whitesun lars" to 1,"R5-D4" to 1,
        "Biggs Darklighter" to 1,"Obi-Wan Kenobi" to 20)

    val listaPeliculas:HashMap<String,Int> = hashMapOf("Luke Skywalker" to 1, "C-3PO" to 1,
        "R2-D2" to 1,"Darth Vader" to 1,"Leia Organa" to 1,"Owen Lars" to 1,"Beru Whitesun lars" to 1,"R5-D4" to 1,
        "Biggs Darklighter" to 1,"Obi-Wan Kenobi" to 1)

    val listaPeliculas2:HashMap<String,Int> = hashMapOf("Luke Skywalker" to 2, "C-3PO" to 2,
        "R2-D2" to 2,"Darth Vader" to 2,"Leia Organa" to 2,"Obi-Wan Kenobi" to 2)

    val listaPelicula3:HashMap<String,Int> = hashMapOf("Luke Skywalker" to 3, "C-3PO" to 3,
        "R2-D2" to 3,"Darth Vader" to 3,"Leia Organa" to 3,"Obi-Wan Kenobi" to 3)

    val listaPeliculas4:HashMap<String,Int> = hashMapOf( "C-3PO" to 4,
        "R2-D2" to 4,"Obi-Wan Kenobi" to 4)

    val listaPeliculas5:HashMap<String,Int> = hashMapOf( "C-3PO" to 5,
        "R2-D2" to 5,"Owen Lars" to 5,"Beru Whitesun lars" to 1,"Obi-Wan Kenobi" to 5)

    val listaPeliculas6:HashMap<String,Int> = hashMapOf("Luke Skywalker" to 6, "C-3PO" to 6,
        "R2-D2" to 6,"Darth Vader" to 6,"Leia Organa" to 6,"Owen Lars" to 6,"Beru Whitesun lars" to 6,"Obi-Wan Kenobi" to 6)

   val listaPeliculaPoster:HashMap<String,Int> = hashMapOf("A New Hope" to 1,"The Empire Strikes Back" to 2,"Return of the Jedi" to 3,
        "The Phantom Menace" to 4,"Attack of the Clones" to 5,"Revenge of the Sith" to 6)
    val listaPoster1:HashMap<String,Int> = hashMapOf("sw1.jpg" to 1,"sw2.jpg" to 2,"sw3.jpg" to 3,"sw4.jpg" to 4,"sw5.jpg" to 5,"sw6.jpg" to 6)



    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getRetrofitImagen(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URLIMAGE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}