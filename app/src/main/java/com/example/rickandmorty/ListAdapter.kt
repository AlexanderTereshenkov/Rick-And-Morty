package com.example.rickandmorty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListAdapter(private val context: MainActivity, private val array: List<Character>) : ArrayAdapter<Character>(
    context, R.layout.one_item, array
) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.one_item, null)
        val nameText:TextView = view.findViewById(R.id.name)
        val raceAndStatus : TextView = view.findViewById(R.id.race_and_status)
        val gender:TextView = view.findViewById(R.id.male)
        nameText.text = array[position].name
        raceAndStatus.text = array[position].status.toString() + " - " + array[position].species
        gender.text = array[position].gender
        return view
    }

}