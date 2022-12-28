package com.example.ejercicio2_starwars_hgaj.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ejercicio2_starwars_hgaj.databinding.ActivityDetailsBinding
import com.example.ejercicio2_starwars_hgaj.model.starApi
import com.example.ejercicio2_starwars_hgaj.model.starDetail
import com.example.ejercicio2_starwars_hgaj.util.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.http.Path
import javax.security.auth.callback.Callback
import retrofit2.Call
//import retrofit2.Callback
import retrofit2.Response


class Details : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        val bundle = intent.extras

        val name = bundle?.getString("name", "")

        val call = Constants.getRetrofit().create(starApi::class.java).personajeDetail(num = String())

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
        }
    }
}