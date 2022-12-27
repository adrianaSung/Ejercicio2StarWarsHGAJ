package com.example.ejercicio2_starwars_hgaj.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio2_starwars_hgaj.databinding.StarwarsElementBinding
import com.example.ejercicio2_starwars_hgaj.model.star
import com.example.ejercicio2_starwars_hgaj.view.activities.MainActivity

class Adapter(private val contexto: Context, private val starwar: star): RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(view: StarwarsElementBinding) : RecyclerView.ViewHolder(view.root) {
        val tvNombre = view.tvNombre
        val tvAltura = view.tvAltura
        val tvNacimiento = view.tvNacimiento
        val tvGenero = view.tvGenero

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StarwarsElementBinding.inflate(LayoutInflater.from(contexto))
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder .tvNombre.text = starwar[position].name
        holder.tvAltura.text=starwar[position].height
        holder.tvNacimiento.text = starwar[position].birth_year
        holder.tvGenero.text= starwar[position].gender

        holder.itemView.setOnClickListener {
            if(contexto is MainActivity) contexto.selectedStar(starwar[position])
        }

        //PARA IMAGENES
        //Glide.with(contexto)
        // .load(starwar[position].
        // .into(holder.tvImagen)

    }

    override fun getItemCount(): Int = starwar.size
}