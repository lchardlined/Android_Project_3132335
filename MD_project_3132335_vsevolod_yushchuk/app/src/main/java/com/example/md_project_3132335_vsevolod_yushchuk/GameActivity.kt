package com.example.md_project_3132335_vsevolod_yushchuk


import android.os.Bundle
import android.view.View
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity



class GameActivity : AppCompatActivity() {


    private lateinit var dialogueText: TextView

    private lateinit var characterName: TextView


    private var dialogueIndex = 0



    private val dialogues = arrayOf(

        "The rain was falling heavily outside.",

        "You hear footsteps approaching behind you.",

        "Someone is standing in the doorway.",

        "The mysterious person looks at you."

    )



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_game)



        dialogueText =
            findViewById(
                R.id.dialogueText
            )


        characterName =
            findViewById(
                R.id.characterName
            )


        val dialogueBox =
            findViewById<View>(
                R.id.dialogueBox
            )



        characterName.text =
            "Narrator"



        dialogueText.text =
            dialogues[dialogueIndex]



        dialogueIndex++



        dialogueBox.setOnClickListener {


            showNextDialogue()


        }


    }





    private fun showNextDialogue() {


        if(dialogueIndex < dialogues.size) {


            dialogueText.text =
                dialogues[dialogueIndex]


            dialogueIndex++


        }

        else {


            dialogueText.text =
                "End of placeholder scene."


        }


    }


}