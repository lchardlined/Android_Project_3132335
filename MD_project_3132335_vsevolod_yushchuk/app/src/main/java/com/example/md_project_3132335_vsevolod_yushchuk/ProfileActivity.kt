package com.example.md_project_3132335_vsevolod_yushchuk


import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity


class ProfileActivity : AppCompatActivity() {


    private lateinit var profileImage: ImageView


    private val CAMERA_REQUEST = 100

    private val GALLERY_REQUEST = 200



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)



        profileImage =
            findViewById(R.id.profileImage)


        val changePhotoButton =
            findViewById<Button>(
                R.id.changePhotoButton
            )


        val backButton =
            findViewById<Button>(
                R.id.backButton
            )


        val coins =
            findViewById<TextView>(
                R.id.coinsProfile
            )


        val stories =
            findViewById<TextView>(
                R.id.storiesCompleted
            )


        val badges =
            findViewById<TextView>(
                R.id.badgesText
            )




        val prefs =
            getSharedPreferences(
                "PlayerData",
                MODE_PRIVATE
            )



        coins.text =
            "Coins: ${
                prefs.getInt(
                    "coins",
                    100
                )
            }"



        stories.text =
            "Stories completed: ${
                prefs.getInt(
                    "stories",
                    0
                )
            }"



        badges.text =
            "Badges: None"





        changePhotoButton.setOnClickListener {


            openImageOptions()


        }




        backButton.setOnClickListener {


            finish()


        }



    }





    private fun openImageOptions(){


        val options =
            arrayOf(
                "Take Photo",
                "Choose From Gallery"
            )


        androidx.appcompat.app.AlertDialog.Builder(this)

            .setTitle("Profile Picture")

            .setItems(options){ _, which ->


                if(which == 0){

                    openCamera()

                }
                else{

                    openGallery()

                }


            }

            .show()


    }






    private fun openCamera(){


        val intent =
            Intent(
                MediaStore.ACTION_IMAGE_CAPTURE
            )


        startActivityForResult(
            intent,
            CAMERA_REQUEST
        )


    }





    private fun openGallery(){


        val intent =
            Intent(
                Intent.ACTION_PICK
            )


        intent.type =
            "image/*"



        startActivityForResult(
            intent,
            GALLERY_REQUEST
        )


    }







    override fun onActivityResult(

        requestCode: Int,

        resultCode: Int,

        data: Intent?

    ){

        super.onActivityResult(
            requestCode,
            resultCode,
            data
        )



        if(resultCode == RESULT_OK){



            if(requestCode == CAMERA_REQUEST){



                val image =
                    data?.extras
                        ?.get("data")
                            as Bitmap



                profileImage.setImageBitmap(
                    image
                )


            }



            if(requestCode == GALLERY_REQUEST){



                val imageUri =
                    data?.data


                profileImage.setImageURI(
                    imageUri
                )


            }


        }


    }


}