package com.alecbrando.pokedex.repository

import com.alecbrando.pokedex.data.remote.PokeApi
import com.alecbrando.pokedex.data.remote.responses.Pokemon
import com.alecbrando.pokedex.data.remote.responses.PokemonList
import com.alecbrando.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int) : Resource<PokemonList> {
       val response = try {
            api.getPokemonList(limit, offset)
        } catch (e : Exception) {
            return Resource.Error(message = "An unknown error occurred")
        }

        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(name: String) : Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(name)
        } catch (e : Exception) {
            return Resource.Error(message = "An unknown error occurred")
        }

        return Resource.Success(response)
    }
}