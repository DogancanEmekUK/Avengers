package com.dogancanemek.avengers

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import kotlin.random.Random

class AvengerActivity : AppCompatActivity() {

    private lateinit var heroImage: ImageView
    private lateinit var heroName: TextView
    private lateinit var heroMotto: TextView
    private lateinit var welcomeText: TextView
    private lateinit var practiceButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avenger)

        heroImage = findViewById(R.id.heroImage)
        heroName = findViewById(R.id.heroName)
        heroMotto = findViewById(R.id.heroMotto)
        welcomeText = findViewById(R.id.welcomeText)
        practiceButton = findViewById(R.id.practiceButton)


        val name = intent.getStringExtra(EXTRA_MESSAGE)
        val welcome = "$name, meet your mentor."
        welcomeText.text = welcome

        val avengerNames = listOf("Iron Man", "Captain America", "Thor", "Hulk", "Black Widow",
            "Hawkeye", "Doctor Strange", "Black Panther", "Winter Soldier", "Spider Man", "Star Lord",
            "Falcon", "Vision", "Scarlett Witch", "War Machine", "Ant Man")

        val ironmanMotto = "I am Iron Man."
        val captainMotto = "I can do this all day."
        val thorMotto = "You shall feel the wrath of mighty Thor!"
        val hulkMotto = "Hulk smash!"
        val widowMotto = "I'm always picking up after you boys..."
        val hawkeyeMotto = "We haven't met yet. I'm Cliff."
        val doctorMotto = "Hello Avenger, have you come to bargain?"
        val pantherMotto = "Wakanda forever!"
        val soldierMotto = "God, I love this place!"
        val spiderMotto = "With great power, comes great responsibilty."
        val starMotto = "Gonna get your love..."
        val visionMotto = "A thing isn't beautiful because it lasts."
        val wandaMotto = "You don't know me? You will..."
        val warMotto = "Yeah, it's called being a badass."
        val falconMotto = "Hey Avenger, do you read me? On your left..."
        val antMotto = "Does anyone have any orange juice?"

        val ironman: Bitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ironman)
        val captain = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.captain)
        val thor = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.thor)
        val hulk = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.hulk)
        val widow = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.widow)
        val hawkeye = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.hawkeye)
        val doctor = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.doctor)
        val panther = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.panther)
        val soldier = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.soldier)
        val spider = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.spider)
        val star = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.star)
        val vision = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.vision)
        val wanda = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.wanda)
        val war = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.war)
        val falcon = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.falcon)
        val ant = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ant)

        heroName.text = avengerNames.random()

        if (name == "Dogancan Emek") {
            heroName.text = "Captain America"
        }

        if (name == "Emrecan Kaba") {
            heroName.text = "Iron Man"
        }

        if (heroName.text == "Iron Man") {
            heroMotto.text = ironmanMotto
            heroImage.setImageBitmap(ironman)
        } else if (heroName.text == "Captain America") {
            heroMotto.text = captainMotto
            heroImage.setImageBitmap(captain)
        } else if (heroName.text == "Thor") {
            heroMotto.text = thorMotto
            heroImage.setImageBitmap(thor)
        } else if (heroName.text == "Hulk") {
            heroMotto.text = hulkMotto
            heroImage.setImageBitmap(hulk)
        } else if (heroName.text == "Black Widow") {
            heroMotto.text = widowMotto
            heroImage.setImageBitmap(widow)
        } else if (heroName.text == "Hawkeye") {
            heroMotto.text = hawkeyeMotto
            heroImage.setImageBitmap(hawkeye)
        } else if (heroName.text == "Doctor Strange") {
            heroMotto.text = doctorMotto
            heroImage.setImageBitmap(doctor)
        } else if (heroName.text == "Black Panther") {
            heroMotto.text = pantherMotto
            heroImage.setImageBitmap(panther)
        } else if (heroName.text == "Winter Soldier") {
            heroMotto.text = soldierMotto
            heroImage.setImageBitmap(soldier)
        } else if (heroName.text == "Spider Man") {
            heroMotto.text = spiderMotto
            heroImage.setImageBitmap(spider)
        } else if (heroName.text == "Star Lord") {
            heroMotto.text = starMotto
            heroImage.setImageBitmap(star)
        } else if (heroName.text == "Vision") {
            heroMotto.text = visionMotto
            heroImage.setImageBitmap(vision)
        } else if (heroName.text == "Scarlett Witch") {
            heroMotto.text = wandaMotto
            heroImage.setImageBitmap(wanda)
        } else if (heroName.text == "War Machine") {
            heroMotto.text = warMotto
            heroImage.setImageBitmap(war)
        } else if (heroName.text == "Falcon") {
            heroMotto.text = falconMotto
            heroImage.setImageBitmap(falcon)
        } else if (heroName.text == "Ant Man") {
            heroMotto.text = antMotto
            heroImage.setImageBitmap(ant)
        }

        practiceButton.setOnClickListener {
            val intent = Intent(applicationContext, GameActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, name)
            }
            startActivity(intent)
            finish()
        }
    }
}
