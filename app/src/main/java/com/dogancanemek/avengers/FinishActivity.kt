package com.dogancanemek.avengers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class FinishActivity : AppCompatActivity() {

    private lateinit var imageAvenger : ImageView
    private lateinit var congratsText : TextView
    private lateinit var imageAssemble : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        imageAvenger = findViewById(R.id.imageAvenger)
        congratsText = findViewById(R.id.congratsText)
        imageAssemble = findViewById(R.id.imageAssemble)

        val name = intent.getStringExtra(EXTRA_MESSAGE)

        congratsText.text = "congratulations $name, you are an avenger now. welcome to the team. click on avengers to finish the game."

        imageAssemble.setOnClickListener {

            finish()

        }

    }
}