package com.example.pokee2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokee2.Common.Common
import com.example.pokee2.Common.ItemOffsetDecoration
import com.example.pokee2.Retrofit.IPokemonlist
import com.example.pokee2.Retrofit.RetrofitClient
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function


class PokemonList : Fragment() {
    internal var compositeDisposable = CompositeDisposable()
    internal var iPokemonList:IPokemonlist


    init {
        val retrofit = RetrofitClient.instance
        iPokemonList = retrofit.create(IPokemonlist::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val itemView = inflater.inflate(R.layout.fragment_pokemon_list, container, false)


        pokemon_recyclerview.setHasFixedSize(true)
        pokemon_recyclerview.layoutManager = GridLayoutManager(activity,2)
        val itemDecoration = ItemOffsetDecoration(requireActivity(),R.dimen.spacing)
        pokemon_recyclerview.addItemDecoration(itemDecoration)

        fetchData()


        return itemView
    }

    private fun fetchData(){
        compositeDisposable.add(iPokemonList.listPokemon
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { pokemon ->
                Common.pokemonList = pokemonDex.pokemon!!
            }
        );

    }

}

