package com.example.rickandmorty


data class Character(val id:Int, val name:String, val status:Status, val species:String, val gender:
String)

enum class Status {Dead, Alive, Unknown}

class GetAllCharacters{
    fun getAllCharacters(): List<Character>{
        return listOf(
            Character(1, "Rick Sanchez", Status.Alive, "Human", "Male"),
            Character(126, "Fleeb", Status.Unknown, "Alien", "unknown"),
            Character(353, "Tiny Rick", Status.Dead, "Human", "Male"),
            Character(377, "Voltematron", Status.Dead, "Alien", "unknown"),
            Character(608, "Jesus Christ", Status.Alive, "Human", "Male"),
            Character(675, "Japheth", Status.Dead, "Humanoid", "Male"),
        )
    }
}
