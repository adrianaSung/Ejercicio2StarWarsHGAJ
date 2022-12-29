package com.example.ejercicio2_starwars_hgaj.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.ejercicio2_starwars_hgaj.databinding.ActivityMainBinding
import com.example.ejercicio2_starwars_hgaj.model.star
import com.example.ejercicio2_starwars_hgaj.model.starApi
import com.example.ejercicio2_starwars_hgaj.model.starPersona
import com.example.ejercicio2_starwars_hgaj.util.Constants
import com.example.ejercicio2_starwars_hgaj.view.adapters.Adapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
//import javax.security.auth.callback.Callback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val call = Constants.getRetrofit().create(starApi::class.java).personaje()


            call.enqueue(object: retrofit2.Callback<starPersona> {
                override fun onResponse(call: Call<starPersona>, response: Response<starPersona>) {
                    //Log.d(Constants.LOGTAG,"Respuesta del servidor: ${response.toString()}" )
                    //Log.d(Constants.LOGTAG,"Datos: ${response.body().toString()}" )


                    binding.rvMenu.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rvMenu.adapter = Adapter(this@MainActivity,response.body()!!)
                    binding.pbConexion.visibility = View.GONE

                }

                override fun onFailure(call: Call<starPersona>, t: Throwable) {
                    binding.pbConexion.visibility = View.GONE

                }

            })

        }
    }

    fun selectedStar(starwar: starPersona, position: Int) {
        val parametros = Bundle()
        


        parametros.apply {
            putString("name", starwar.results[position].name)
        }
        val intent = Intent(this@MainActivity,Details::class.java)
        intent.putExtras(parametros)
        startActivity(intent)



    }
}