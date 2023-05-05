package com.aliduman.savemyage

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var preferences : SharedPreferences
    private lateinit var save_button : Button
    private lateinit var age_text : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        save_button = findViewById(R.id.save_button)
        age_text = findViewById(R.id.age_text)

        preferences = this.getSharedPreferences("com.aliduman.savemyage", Context.MODE_PRIVATE)

        var currentAge = preferences.getInt("age",-1)


            if (currentAge != -1) { //if user saved age before..
                age_text.hint = currentAge.toString()

            } else {//if first time user saved age

                save_button.setOnClickListener {

                    var ageInput =  Integer.valueOf(age_text.text.toString())
                    preferences.edit().putInt("age", ageInput).apply() //We save it to SharedPreferences.

                }
            }
    }
}