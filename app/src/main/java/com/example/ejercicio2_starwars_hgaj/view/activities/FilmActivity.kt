package com.example.ejercicio2_starwars_hgaj.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.ejercicio2_starwars_hgaj.databinding.ActivityDetailsBinding
import com.example.ejercicio2_starwars_hgaj.databinding.ActivityFilmBinding
import com.example.ejercicio2_starwars_hgaj.model.*
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
        var caracterPel2: Int= 0
        var caracterPel3: Int = 0
        var caracterPel4: Int= 0
        var caracterPel5: Int = 0
        var caracterPel6: Int= 0
        var poster1: Int=0


        val bundle = intent.extras
        val name = bundle?.getString("name", "")


        for ((clave, valor) in Constants.listaPeliculas){
            if (clave.equals(name.toString())) {
                caracterPel = valor
            }
        }
        for ((clave, valor) in Constants.listaPeliculas2){
            if (clave.equals(name.toString())) {
                caracterPel2 = valor
            }
        }
        for ((clave, valor) in Constants.listaPelicula3){
            if (clave.equals(name.toString())) {
                caracterPel3 = valor
            }
        }
        for ((clave, valor) in Constants.listaPeliculas4){
            if (clave.equals(name.toString())) {
                caracterPel4 = valor
            }
        }
        for ((clave, valor) in Constants.listaPeliculas5){
            if (clave.equals(name.toString())) {
                caracterPel5 = valor
            }
        }
        for ((clave, valor) in Constants.listaPeliculas6){
            if (clave.equals(name.toString())) {
                caracterPel6 = valor
            }
        }
        for ((clave, valor) in Constants.listaPoster1){
            if (clave.equals(name.toString())) {
                poster1= valor
            }
        }
        val call = Constants.getRetrofit().create(starApi::class.java).peliculaDetail(caracterPel)
        val call2 = Constants.getRetrofit().create(starApi::class.java).peliculaDetail(caracterPel2)
        val call3 = Constants.getRetrofit().create(starApi::class.java).peliculaDetail(caracterPel3)
        val call4 = Constants.getRetrofit().create(starApi::class.java).peliculaDetail(caracterPel4)
        val call5 = Constants.getRetrofit().create(starApi::class.java).peliculaDetail(caracterPel5)
        val call6 = Constants.getRetrofit().create(starApi::class.java).peliculaDetail(caracterPel6)
        val call7 = Constants.getRetrofit().create(starApi::class.java).posterDetail(poster1)
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
        call2.enqueue(object: retrofit2.Callback<starPeliculaDetail> {
            override fun onResponse(call: Call<starPeliculaDetail>, response: Response<starPeliculaDetail>) {
                binding.pbConexion.visibility = View.GONE
                with(binding){
                    tvPeliculaS1.text = response.body()?.title

                }


            }

            override fun onFailure(call: Call<starPeliculaDetail>, t: Throwable) {
                binding.pbConexion.visibility = View.GONE

            }

        })
        call3.enqueue(object: retrofit2.Callback<starPeliculaDetail> {
            override fun onResponse(call: Call<starPeliculaDetail>, response: Response<starPeliculaDetail>) {
                binding.pbConexion.visibility = View.GONE
                with(binding){
                    tvPeliculaS3.text = response.body()?.title

                }


            }

            override fun onFailure(call: Call<starPeliculaDetail>, t: Throwable) {
                binding.pbConexion.visibility = View.GONE

            }

        })
        call4.enqueue(object: retrofit2.Callback<starPeliculaDetail> {
            override fun onResponse(call: Call<starPeliculaDetail>, response: Response<starPeliculaDetail>) {
                binding.pbConexion.visibility = View.GONE
                with(binding){
                    tvPeliculaS4.text = response.body()?.title

                }


            }

            override fun onFailure(call: Call<starPeliculaDetail>, t: Throwable) {
                binding.pbConexion.visibility = View.GONE

            }

        })
        call5.enqueue(object: retrofit2.Callback<starPeliculaDetail> {
            override fun onResponse(call: Call<starPeliculaDetail>, response: Response<starPeliculaDetail>) {
                binding.pbConexion.visibility = View.GONE
                with(binding){
                    tvPeliculaS5.text = response.body()?.title

                }


            }

            override fun onFailure(call: Call<starPeliculaDetail>, t: Throwable) {
                binding.pbConexion.visibility = View.GONE

            }

        })
        call6.enqueue(object: retrofit2.Callback<starPeliculaDetail> {
            override fun onResponse(call: Call<starPeliculaDetail>, response: Response<starPeliculaDetail>) {
                binding.pbConexion.visibility = View.GONE
                with(binding){
                   // tvPeliculaS6.text = response.body()?.title

                }


            }

            override fun onFailure(call: Call<starPeliculaDetail>, t: Throwable) {
                binding.pbConexion.visibility = View.GONE

            }

        })
        call7.enqueue(object: retrofit2.Callback<posterDetails> {
            override fun onResponse(call: Call<posterDetails>, response: Response<posterDetails>) {
                binding.pbConexion.visibility = View.GONE
                with(binding){
                    Glide.with(this@FilmActivity)
                        .load(response.body()?.posterImagen)
                        .into(imgPoster1)
                }


            }

            override fun onFailure(call: Call<posterDetails>, t: Throwable) {
                binding.pbConexion.visibility = View.GONE

            }

        })


    }
}
