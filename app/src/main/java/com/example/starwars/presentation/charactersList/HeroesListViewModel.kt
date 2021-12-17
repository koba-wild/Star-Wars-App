package com.example.starwars.presentation.charactersList

import androidx.lifecycle.*
import com.example.starwars.data.Hero
import com.example.starwars.data.HeroTitle
import com.example.starwars.data.Heroes
import com.example.starwars.data.ResultHero
import com.example.starwars.db.DbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroesListViewModel (private val dbRepository: DbRepository) : ViewModel() {

    private lateinit var heroList: Heroes
    val heroesData: LiveData<List<HeroTitle>> = dbRepository.getAllHeroes()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            heroList = dbRepository.getRemoteHeroes()
            dbRepository.addAllHeroes(heroList.heroes)
        }
    }

    suspend fun getDetails(position: Int): ResultHero {
        val detailsHero = dbRepository.getRemoteHero(position.toString())
        return detailsHero
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