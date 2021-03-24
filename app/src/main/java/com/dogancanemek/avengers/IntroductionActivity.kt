package com.dogancanemek.avengers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
const val EXTRA_MESSAGE = "com.dogancanemek.avengers"

class IntroductionActivity : AppCompatActivity() {

    private lateinit var shield : ImageView
    private lateinit var avengerNameText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)

        shield = findViewById(R.id.shield)
        avengerNameText = findViewById(R.id.avengerNameText)


        shield.setOnClickListener {
            val name = avengerNameText.text.toString()
            val intent = Intent(applicationContext, AvengerActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, name)
            }
            startActivity(intent)
            finish()
        }
    }
}