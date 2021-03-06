package com.example.pokee2.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokee2.Model.Pokemon
import com.example.pokee2.PokemonList
import com.example.pokee2.R

class PokemonListAdapter (internal var context: Context,
internal var pokemonList: List<Pokemon>):RecyclerView.Adapter<RecyclerView.MyviewHolder>(){

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        internal var img_pokemon:ImageView
        internal var txt_pokemon:TextView
        init {
            img_pokemon = itemView.findViewById(R.id.pokemon_image) as ImageView
            txt_pokemon = itemView.findViewById(R.id.pokemon_name) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.MyviewHolder {
     val  itemView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.MyviewHolder, position: Int) {
      Glide.with(context).load(context).load(pokemonList[position].img).into(holder.img_pokemon)
        holder.txt_pokemon.text=pokemonList[position].name

    override fun getItemCount(): Int {
       return pokemonList.size
    }
}