package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

const val NAME:String = "name"
/*
const val IMG:Int = 0
const val RACEANDSTATUS:String = "race"
const val GEN:String = "gen"
const val ORI:String = "ori"
const val LOC:String = "loc"
*/

class MainActivity2 : AppCompatActivity() {
    private lateinit var getCharacters:GetAllCharacters
    private lateinit var nameText:TextView
    private lateinit var raceAndStatus:TextView
    private lateinit var gender:TextView
    private lateinit var origin:TextView
    private lateinit var location:TextView
    private lateinit var img:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        img = findViewById(R.id.photo)
        nameText = findViewById(R.id.textView)
        raceAndStatus = findViewById(R.id.textView2)
        gender = findViewById(R.id.textView3)
        origin = findViewById(R.id.textView4)
        location = findViewById(R.id.textView5)
        getCharacters = GetAllCharacters()
        val index = intent.getIntExtra(NAME, 0)
        val allCharacters:Character = getCharacters.getAllCharacters()[index]
        setupScreen(allCharacters)
    }
    private fun setupScreen(character: Character) : Unit{
        nameText.text = character.name
        raceAndStatus.text = character.status.toString() + " - " + character.species
        img.setImageResource(character.img)
        gender.text = character.gender
        origin.text = character.origin
        location.text = character.location
    }
}