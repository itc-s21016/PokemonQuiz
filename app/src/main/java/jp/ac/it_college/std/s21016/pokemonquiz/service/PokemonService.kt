package jp.ac.it_college.std.s21016.pokemonquiz.service

import jp.ac.it_college.std.s21016.pokemonquiz.json.PokemonImgInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("https://pokeapi.co/api/v2/{id}")
    fun getPokemon(
        @Path("id")id: Int
    ): Call<PokemonImgInfo>
}
