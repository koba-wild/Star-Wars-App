package com.example.starwars.presentation.heroList

import androidx.lifecycle.*
import com.example.starwars.data.detailHero.Hero
import com.example.starwars.data.heroTitle.Heroes
import com.example.starwars.data.detailHero.Base
import com.example.starwars.db.DbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroesListViewModel (private val dbRepository: DbRepository) : ViewModel() {

    val heroesData: LiveData<List<Hero>> = dbRepository.getAllHeroes()
    var resultHeroes = ArrayList<Base>()
    var heroes = ArrayList<Hero>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getAllHeroDetails()
        }
    }

    suspend fun getHeroTitles(): Heroes {
        return dbRepository.getRemoteHeroes()
    }

    suspend fun getHero(uid:Int): Base {
        return dbRepository.getRemoteHero(uid)
    }

    suspend fun getAllHeroDetails() {
            val heroTitles = getHeroTitles()
            for (i in 0..heroTitles.heroes.size-1) {
                resultHeroes.add(getHero(heroTitles.heroes[i].uid.toInt()))
                heroes.add(resultHeroes[i].result.hero)
                heroes.get(i).uid = resultHeroes[i].result.uid.toInt()
            }
            dbRepository.addAllHeroes(heroes)
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