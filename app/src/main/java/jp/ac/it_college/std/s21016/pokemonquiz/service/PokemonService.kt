package jp.ac.it_college.std.s21016.pokemonquiz.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("https://pokeapi.co/api/v2/")
    suspend fun getPokemonInfo(
        @Path("pokeId") pokeId: Int
    ): Response<PokemonResponse>
}
data class PokemonResponse(
    val pokemon: List<Poke>
)

data class Poke(
    val id: Int,
    val name: String
)