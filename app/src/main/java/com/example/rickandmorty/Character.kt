package com.example.rickandmorty

import android.media.Image


data class Character(val id:Int, val name:String, val status:Status, val species:String, val gender:
String,val origin:String, val location:String, val img:Int)

enum class Status {Dead, Alive, Unknown}

class GetAllCharacters{
    fun getAllCharacters(): List<Character>{
        return listOf(
            Character(8, "Adjudicator Rick", Status.Dead, "Human", "Male",
                "unknown", "Citadel of Ricks", R.drawable.adjudicator),
            Character(211, "Ma-Sha", Status.Alive, "Alien", "Female",
            "Gazorpazorp", "Gazorpazorp", R.drawable.ma),
            Character(304, "Scary Brandon", Status.Alive, "Mythological Creature",
                "Male", "Mr. Goldenfold's dream", "Mr. Goldenfold's dream",
                R.drawable.scary),
            Character(405, "Trunkphobic suspenders guy", Status.Alive,
                "Human", "Male", "unknown", "Earth (Replacement Dimension",
            R.drawable.trun),
            Character(628, "Beth Smith", Status.Alive, "Human", "Female",
            "Morty’s Story", "Morty’s Story", R.drawable.beth),
            Character(805, "Baby Mouse Skin Morty", Status.Alive, "Human",
                "Male", "Citadel of Ricks", "Citadel of Ricks", R.drawable.baby)
        )
    }
}
