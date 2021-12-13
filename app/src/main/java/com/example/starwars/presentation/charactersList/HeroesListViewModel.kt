package com.example.starwars.presentation.charactersList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.starwars.data.Hero
import com.example.starwars.db.DbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroesListViewModel (private val dbRepository: DbRepository) : ViewModel() {

    private lateinit var heroes: List<Hero>
    val heroesData: LiveData<List<Hero>> = dbRepository.getAllHeroes()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            heroes = dbRepository.getRemoteHeroes()
            dbRepository.addAllHeroes(heroes)
        }
    }
}

class ViewModelFactory(private val dbRepository: DbRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HeroesListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HeroesListViewModel(dbRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}