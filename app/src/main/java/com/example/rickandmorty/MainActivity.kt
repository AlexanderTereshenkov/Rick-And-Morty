package com.example.rickandmorty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var searchButton:Button
    private lateinit var editText: EditText
    //private lateinit var list:ListView
    private var getCharacters:GetAllCharacters = GetAllCharacters()

    override fun onCreate(savedInstanceState: Bundle?) {
        val characters:List<Character> = getCharacters.getAllCharacters();
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchButton = findViewById(R.id.searchButton)
        editText = findViewById(R.id.editTxt)
        //list = findViewById(R.id.listView)

        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                var matchNames : List<Character> = listOf()
                for(i in 0 until characters.size){
                    if(characters[i].name.startsWith(s.toString())){
                        matchNames = matchNames + characters[i]
                    }
                }
                for(i in 0 until matchNames.size){
                    Log.i("boo", matchNames[i].name)
                }
                Log.i("boo", "----")

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        searchButton.setOnClickListener(View.OnClickListener {
            val characterName:String = editText.text.toString()
            if(characterName != ""){
                for(i in 0 until characterName.length - 1){
                    if(characters[i].name == characterName){
                        val newIntent = Intent(this, MainActivity2::class.java)
                        newIntent.putExtra(NAME, i)
                        startActivity(newIntent)
                    }
                }
            }
        })
    }

}