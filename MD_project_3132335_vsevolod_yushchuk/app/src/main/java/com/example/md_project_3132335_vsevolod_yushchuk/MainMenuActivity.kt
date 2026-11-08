package com.example.md_project_3132335_vsevolod_yushchuk

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity


class MainMenuActivity : AppCompatActivity() {


    private lateinit var coinsText: TextView

    private lateinit var prefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_layout)



        coinsText = findViewById(R.id.coinText)


        val profileButton =
            findViewById<ImageButton>(R.id.profileButton)


        val settingsButton =
            findViewById<ImageButton>(R.id.settingsButton)


        val playButton =
            findViewById<Button>(R.id.playButton)



        prefs =
            getSharedPreferences(
                "PlayerData",
                MODE_PRIVATE
            )



        loadCoins()



        /*
        Explicit Intent:
        Main Menu -> Profile
        */

        profileButton.setOnClickListener {


            val intent =
                Intent(
                    this,
                    ProfileActivity::class.java
                )


            startActivity(intent)

        }





        /*
        Explicit Intent:
        Main Menu -> Game
        */

        playButton.setOnClickListener {


            val intent =
                Intent(
                    this,
                    GameActivity::class.java
                )


            intent.putExtra(
                "storyID",
                1
            )


            startActivity(intent)


        }








    }



    private fun loadCoins(){


        val coins =

            prefs.getInt(
                "coins",
                100
            )


        coinsText.text =
            "Coins: $coins"


    }


}