package com.example.starwars.presentation.heroList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.data.detailHero.Hero
import com.example.starwars.data.heroTitle.HeroTitle
import com.example.starwars.db.StarWarsApplication

class HeroesListFragment : Fragment(R.layout.fragment_star_wars_list), OnHeroClickListener {

    private val viewModel: HeroesListViewModel by viewModels {
        ViewModelFactory((activity?.applicationContext as StarWarsApplication).repository)
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HeroesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        adapter = HeroesAdapter(this)
        recyclerView.adapter = adapter

        viewModel.heroesData.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    override fun onHeroClick(hero: Hero, position: Int) {
        viewModel.heroesData.observe(viewLifecycleOwner, {
            val action = HeroesListFragmentDirections.actionStarWarsListToDetails(it[position])
            view?.findNavController()?.navigate(action)
        })
    }
}