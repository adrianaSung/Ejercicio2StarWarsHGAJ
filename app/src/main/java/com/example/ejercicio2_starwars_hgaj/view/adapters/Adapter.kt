package com.example.ejercicio2_starwars_hgaj.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio2_starwars_hgaj.databinding.StarwarsElementBinding
import com.example.ejercicio2_starwars_hgaj.model.star
import com.example.ejercicio2_starwars_hgaj.model.starPersona
import com.example.ejercicio2_starwars_hgaj.util.Constants
import com.example.ejercicio2_starwars_hgaj.view.activities.MainActivity

class Adapter(private val contexto: Context, private val starwar: starPersona): RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(view: StarwarsElementBinding) : RecyclerView.ViewHolder(view.root) {
        val tvNombre = view.tvNombre
        val tvAltura = view.tvAltura
        val tvNacimiento = view.tvNacimiento
        val tvGenero = view.tvGenero
        val tvNumero= view.tvNumero

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StarwarsElementBinding.inflate(LayoutInflater.from(contexto))
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        for ((clave, valor) in Constants.listaPersonajes){
            if (clave.equals(starwar.results[position].name)) {
                holder.tvNumero.text = valor.toString()
            }
        }

        holder.tvNombre.text = starwar.results[position].name
        holder.tvAltura.text=starwar.results[position].height
        holder.tvNacimiento.text = starwar.results[position].birth_year
        holder.tvGenero.text= starwar.results[position].gender

        holder.itemView.setOnClickListener {
            if(contexto is MainActivity){
                contexto.selectedStar(starwar,position)
            }
        }

        //PARA IMAGENES
        //Glide.with(contexto)
        // .load(starwar[position].
        // .into(holder.tvImagen)

    }

    override fun getItemCount(): Int = starwar.results.size
}