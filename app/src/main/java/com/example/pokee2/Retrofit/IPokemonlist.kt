package com.example.pokee2.Retrofit

import com.example.pokee2.Model.Pokedex
import io.reactivex.Observable
import retrofit2.http.GET

interface IPokemonlist {
    @get:GET(value = "pokedex.json")
    val listPokemon:Observable<Pokedex>
}