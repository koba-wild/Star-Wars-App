package com.example.starwars.presentation.charactersList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.data.HeroTitle
import com.example.starwars.presentation.DiffCallback

class HeroesAdapter(val clickListener: OnHeroClickListener) : ListAdapter<HeroTitle, HeroesAdapter.CharacterViewHolder>(DiffCallback<HeroTitle>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        var item = getItem(position) as HeroTitle
        holder.bind(item, clickListener)
    }


    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val characterName: TextView = itemView.findViewById(R.id.char_name)

        fun bind(hero: HeroTitle, action: OnHeroClickListener) {
            characterName.text = hero.name
            itemView.setOnClickListener {
                action.onHeroClick(hero, adapterPosition)
            }
        }
    }
}

interface OnHeroClickListener {
    fun onHeroClick(hero: HeroTitle, position: Int)
}
