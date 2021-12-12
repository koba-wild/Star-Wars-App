package com.example.starwars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class StarWarsList : Fragment(R.layout.fragment_star_wars_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.textView).setOnClickListener {
            findNavController().navigate(R.id.action_starWarsList_to_details)
        }
    }
}