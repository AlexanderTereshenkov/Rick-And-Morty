package com.example.rickandmorty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import com.example.rickandmorty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var list:ListView
    private lateinit var bind : ActivityMainBinding
    private var characters:List<Character> = GetAllCharacters().getAllCharacters()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        editText = findViewById(R.id.editTxt)
        list = findViewById(R.id.listView)
        bind.listView.adapter = ListAdapter(this, characters)
        bind.listView.isClickable = true
        clickableList(characters)
        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                var matchNames : List<Character> = listOf()
                for(i in 0 until characters.size){
                    if(characters[i].name.startsWith(s.toString().replaceFirstChar{it.uppercase()})){
                        matchNames = matchNames + characters[i]
                    }
                }
                if(s.toString() != ""){
                    bind.listView.adapter = ListAdapter(this@MainActivity, matchNames)
                    clickableList(matchNames)
                }
                else{
                    bind.listView.adapter = ListAdapter(this@MainActivity, characters)
                    clickableList(characters)
                }

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

    }
    private fun clickableList(array : List<Character>) : Unit{
        bind.listView.setOnItemClickListener { parent, view, position, id ->
            val index = characters.indexOf(array[position])
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra(NAME, index)
            startActivity(intent)
        }
    }
}