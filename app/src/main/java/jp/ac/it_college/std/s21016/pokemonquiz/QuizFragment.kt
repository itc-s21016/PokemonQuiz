package jp.ac.it_college.std.s21016.pokemonquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.UiThread
import androidx.navigation.fragment.navArgs
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import jp.ac.it_college.std.s21016.pokemonquiz.databinding.FragmentQuizBinding
import jp.ac.it_college.std.s21016.pokemonquiz.service.Poke


class QuizFragment : Fragment() {
    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private var pokemonList: List<Poke>? = null

    private val args: QuizFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        binding.gen.text = getString(R.string.gen_select, args.num)
        return binding.root


        initPokemonList()

    }


    private fun initPokemonList() {
        val jsonStr = resources.assets.open("ordered_pokemon.json").reader().readText()
        val type = Types.newParameterizedType(List::class.java, Poke::class.java)
        val adapter: JsonAdapter<List<Poke>> = moshi.adapter(type)

        pokemonList = adapter.fromJson(jsonStr)

    }


}