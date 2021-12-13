package com.example.starwars.presentation.charactersList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.data.Hero
import com.example.starwars.presentation.DiffCallback

class CharactersAdapter(val clickListener: OnHeroClickListener) : ListAdapter<Hero, CharactersAdapter.CharacterViewHolder>(DiffCallback<Hero>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_star_wars_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        var item = getItem(position) as Hero
        holder.bind(item, clickListener)
    }


    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val characterName: TextView = itemView.findViewById(R.id.char_name)

        fun bind(hero: Hero, action: OnHeroClickListener) {
            characterName.text = hero.name
            itemView.setOnClickListener {
                action.onHeroClick(hero, adapterPosition)
            }
        }
    }
}

interface OnHeroClickListener {
    fun onHeroClick(hero: Hero, position: Int)
}
