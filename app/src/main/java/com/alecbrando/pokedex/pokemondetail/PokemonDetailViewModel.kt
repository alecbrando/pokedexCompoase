package com.alecbrando.pokedex.pokemondetail

import androidx.lifecycle.ViewModel
import com.alecbrando.pokedex.data.remote.responses.Pokemon
import com.alecbrando.pokedex.repository.PokemonRepository
import com.alecbrando.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemon: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemon)
    }

}