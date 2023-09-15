package com.example.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private var isPlayVisible:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageButtonPause: ImageButton = findViewById(R.id.imageButtonPause)
        val imageButtonPlay: ImageButton = findViewById(R.id.imageButtonPlay)

        imageButtonPause.setOnClickListener {

            imageButtonPause.visibility = View.INVISIBLE
            imageButtonPlay.visibility = View.VISIBLE
            isPlayVisible = true

        }

        imageButtonPlay.setOnClickListener {

            imageButtonPause.visibility = View.VISIBLE
            imageButtonPlay.visibility = View.INVISIBLE
            isPlayVisible = false

        }

    }

    override fun onResume(){
        super.onResume()

        val pause:ImageButton = findViewById(R.id.imageButtonPause)
        val play:ImageButton = findViewById(R.id.imageButtonPlay)

        if (isPlayVisible) {

            pause.visibility = View.INVISIBLE
            play.visibility = View.VISIBLE

        } else {

            pause.visibility = View.VISIBLE
            play.visibility = View.INVISIBLE

        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("playStatus", isPlayVisible)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        isPlayVisible = savedInstanceState.getBoolean("playStatus")
    }
}