package com.example.ejercicio2_starwars_hgaj.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ejercicio2_starwars_hgaj.databinding.ActivityDetailsBinding
import com.example.ejercicio2_starwars_hgaj.databinding.ActivityFilmBinding
import com.example.ejercicio2_starwars_hgaj.model.starApi
import com.example.ejercicio2_starwars_hgaj.model.starDetail
import com.example.ejercicio2_starwars_hgaj.model.starPeliculaDetail
import com.example.ejercicio2_starwars_hgaj.util.Constants
import retrofit2.Call
import retrofit2.Response

class FilmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFilmBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var caracterPel: Int = 0
        val bundle = intent.extras
        val name = bundle?.getString("name", "")
        for ((clave, valor) in Constants.listaPeliculas){
            if (clave.equals(name.toString())) {
                caracterPel = valor
            }
        }
        val call = Constants.getRetrofit().create(starApi::class.java).peliculaDetail(caracterPel)
        call.enqueue(object: retrofit2.Callback<starPeliculaDetail> {
            override fun onResponse(call: Call<starPeliculaDetail>, response: Response<starPeliculaDetail>) {
                binding.pbConexion.visibility = View.GONE
                with(binding){
                    tvPeliculaS.text = response.body()?.title

                }


            }

            override fun onFailure(call: Call<starPeliculaDetail>, t: Throwable) {
                binding.pbConexion.visibility = View.GONE

            }

        })

    }
}
