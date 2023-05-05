package com.aliduman.savemyage

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var preferences : SharedPreferences
    private lateinit var age_button : Button
    private lateinit var age_text : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        age_button = findViewById(R.id.save_button)
        age_text = findViewById(R.id.age_text)

        preferences = this.getSharedPreferences("com.aliduman.savemyage", Context.MODE_PRIVATE)

        var currentAge = preferences.getInt("age",-1)

        if (currentAge != -1) {
            age_text.hint = currentAge.toString()

        } else {
            age_button.setOnClickListener {

                var ageInput =  Integer.valueOf(age_text.text.toString())
                preferences.edit().putInt("age", ageInput).apply()
            }

        }












    }
}