package com.example.ejercicio2_starwars_hgaj.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ejercicio2_starwars_hgaj.databinding.ActivityDetailsBinding
import com.example.ejercicio2_starwars_hgaj.model.starApi
import com.example.ejercicio2_starwars_hgaj.model.starDetail
import com.example.ejercicio2_starwars_hgaj.model.starPlanetaDetail
import com.example.ejercicio2_starwars_hgaj.util.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
//import retrofit2.Callback
import retrofit2.Response


class Details : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        var caracterPer: Int = 0
        var caracterPlan: Int= 0

        val bundle = intent.extras

        val name = bundle?.getString("name", "")
        val namePlanet = bundle?.getString("namePlanet", "")
        for ((clave, valor) in Constants.listaPlanetas){
            if (clave.equals(namePlanet.toString())) {
                caracterPlan = valor
            }
        }

        for ((clave, valor) in Constants.listaPersonajes){
            if (clave.equals(name.toString())) {
                caracterPer = valor
            }
        }

        val call = Constants.getRetrofit().create(starApi::class.java).personajeDetail(caracterPer)
        val call2= Constants.getRetrofit().create(starApi::class.java).planetaDetail(caracterPlan)

        CoroutineScope(Dispatchers.IO).launch {

            call.enqueue(object: retrofit2.Callback<starDetail> {
                override fun onResponse(call: Call<starDetail>, response: Response<starDetail>) {
                    binding.pbConexion.visibility = View.GONE
                    with(binding){
                        tvPersonaje.text = response.body()?.name
                    }


                }

                override fun onFailure(call: Call<starDetail>, t: Throwable) {
                    binding.pbConexion.visibility = View.GONE

                }

            })
            call2.enqueue(object: retrofit2.Callback<starPlanetaDetail> {
                override fun onResponse(call: Call<starPlanetaDetail>, response: Response<starPlanetaDetail>)
                {
                    binding.pbConexion.visibility = View.GONE
                    with(binding){
                        tvNombrePlaneta.text = response.body()?.name
                        tvClima.text=response.body()?.climate
                        tvDiametro.text=response.body()?.diameter
                        tvPeriodoO.text= response.body()?.orbital_period
                        tvPeriodoR.text=response.body()?.rotation_period
                        tvTerreno.text= response.body()?.terrain
                        tvPoblacion.text= response.body()?.population

                    }
                }

                override fun onFailure(call: Call<starPlanetaDetail>, t: Throwable) {
                    binding.pbConexion.visibility = View.GONE

                }

            })
        }
    }
}