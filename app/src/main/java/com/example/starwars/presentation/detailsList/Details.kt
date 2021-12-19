package com.example.starwars.presentation.detailsList

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.starwars.R

class Details : Fragment(R.layout.fragment_details) {

    private val heroImage: ImageView by lazy { requireView().findViewById(R.id.heroImage) }
    private val name: TextView by lazy { requireView().findViewById(R.id.heroName) }
    private val birthYear: TextView by lazy { requireView().findViewById(R.id.birthYear) }
    private val eyeColor: TextView by lazy { requireView().findViewById(R.id.eyeColor) }
    private val hairColor: TextView by lazy { requireView().findViewById(R.id.hairColor) }
    private val height: TextView by lazy { requireView().findViewById(R.id.height) }
    private val mass: TextView by lazy { requireView().findViewById(R.id.mass) }
    private val homeworld: TextView by lazy { requireView().findViewById(R.id.homeworld) }
    private val films: TextView by lazy { requireView().findViewById(R.id.films) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var args = DetailsArgs.fromBundle(arguments!!)


    }
}