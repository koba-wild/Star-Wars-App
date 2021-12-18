package com.example.starwars.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.starwars.R

class Details : Fragment(R.layout.fragment_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var args = DetailsArgs.fromBundle(arguments!!)
        Toast.makeText(context, "NumCorrect: ${args.uid}, NumQuestions: ${args.uid}", Toast.LENGTH_LONG).show()
    }
}