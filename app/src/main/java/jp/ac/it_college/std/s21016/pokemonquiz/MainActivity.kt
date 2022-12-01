package jp.ac.it_college.std.s21016.pokemonquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import jp.ac.it_college.std.s21016.pokemonquiz.databinding.ActivityMainBinding
import jp.ac.it_college.std.s21016.pokemonquiz.service.Poke

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
//    private var pokemonList: List<Poke>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initPokemonList()


        //画面遷移をわかりやすくするため
        val navController =
            binding.fragmentContainerView.getFragment<NavHostFragment>().navController
        binding.toolbar.setupWithNavController(
            navController,
            AppBarConfiguration(navController.graph)
        )
    }
//    private fun initPokemonList() {
//        val jsonStr = resources.assets.open("ordered_pokemon.json").reader().readText()
//        val type = Types.newParameterizedType(List::class.java, Poke::class.java)
//        val adapter: JsonAdapter<List<Poke>> = moshi.adapter(type)
//
//        pokemonList = adapter.fromJson(jsonStr)
//
//    }
}