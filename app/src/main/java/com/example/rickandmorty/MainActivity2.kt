package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

const val NAME:String = "name"

class MainActivity2 : AppCompatActivity() {
    private lateinit var getCharacters:GetAllCharacters
    private lateinit var nameText:TextView
    private lateinit var status:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        nameText = findViewById(R.id.textView)
        status = findViewById(R.id.textView2)
        getCharacters = GetAllCharacters()
        val index = intent.getIntExtra(NAME, 0)
        val allCharacters:Character = getCharacters.getAllCharacters()[index]
        setupScreen(allCharacters)
    }
    private fun setupScreen(character: Character) : Unit{
        nameText.text = character.name
        status.text = character.status.toString()
    }
}