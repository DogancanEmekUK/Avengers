package com.dogancanemek.avengers

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*
import kotlin.collections.ArrayList

class GameActivity3 : AppCompatActivity() {

    var score = 0
    var imageArray = ArrayList<ImageView>()
    var handler = Handler()
    var runnable = Runnable {  }
    private lateinit var image1 : ImageView
    private lateinit var image2 : ImageView
    private lateinit var image3 : ImageView
    private lateinit var image4 : ImageView
    private lateinit var image5 : ImageView
    private lateinit var image6 : ImageView
    private lateinit var image7 : ImageView
    private lateinit var image8 : ImageView
    private lateinit var image9 : ImageView
    private lateinit var image10 : ImageView
    private lateinit var image11 : ImageView
    private lateinit var image12 : ImageView
    private lateinit var image13 : ImageView
    private lateinit var image14 : ImageView
    private lateinit var image15 : ImageView
    private lateinit var image16 : ImageView
    private lateinit var timeText: TextView
    private lateinit var scoreText: TextView
    private lateinit var fightText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game3)

        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)
        image3 = findViewById(R.id.image3)
        image4 = findViewById(R.id.image4)
        image5 = findViewById(R.id.image5)
        image6 = findViewById(R.id.image6)
        image7 = findViewById(R.id.image7)
        image8 = findViewById(R.id.image8)
        image9 = findViewById(R.id.image9)
        image10 = findViewById(R.id.image10)
        image11 = findViewById(R.id.image11)
        image12 = findViewById(R.id.image12)
        image13 = findViewById(R.id.image13)
        image14 = findViewById(R.id.image14)
        image15 = findViewById(R.id.image15)
        image16 = findViewById(R.id.image16)
        timeText = findViewById(R.id.timeText)
        scoreText = findViewById(R.id.scoreText)
        fightText = findViewById(R.id.fightText)

        imageArray.add(image1)
        imageArray.add(image2)
        imageArray.add(image3)
        imageArray.add(image4)
        imageArray.add(image5)
        imageArray.add(image6)
        imageArray.add(image7)
        imageArray.add(image8)
        imageArray.add(image9)
        imageArray.add(image10)
        imageArray.add(image11)
        imageArray.add(image12)
        imageArray.add(image13)
        imageArray.add(image14)
        imageArray.add(image15)
        imageArray.add(image16)

        val name = intent.getStringExtra(EXTRA_MESSAGE)
        fightText.text = "$name, kill them properly this time."

        val cull: Bitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.cull)
        val dormammu = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.dormammu)
        val ego = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ego)
        val hela = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.hela)
        val hydra = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.hydra)
        val loki = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.loki)
        val maw = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.maw)
        val midnight = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.midnight)
        val monger = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.monger)
        val mysterio = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.mysterio)
        val ronan = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ronan)
        val skull = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.skull)
        val surtur = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.surtur)
        val thanos = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.thanos)
        val ultron = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ultron)
        val vulture = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.vulture)

        image1.setImageBitmap(cull)
        image2.setImageBitmap(dormammu)
        image3.setImageBitmap(ego)
        image4.setImageBitmap(hela)
        image5.setImageBitmap(hydra)
        image6.setImageBitmap(loki)
        image7.setImageBitmap(maw)
        image8.setImageBitmap(midnight)
        image9.setImageBitmap(monger)
        image10.setImageBitmap(mysterio)
        image11.setImageBitmap(ronan)
        image12.setImageBitmap(skull)
        image13.setImageBitmap(surtur)
        image14.setImageBitmap(thanos)
        image15.setImageBitmap(ultron)
        image16.setImageBitmap(vulture)

        hideImages()

        //CountdownTimer

        object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeText.text = "Time: " + millisUntilFinished/1000
            }

            override fun onFinish() {
                timeText.text = "Time: 0"
                handler.removeCallbacks(runnable)
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                //Alert
                val alert = AlertDialog.Builder(this@GameActivity3)
                alert.setTitle("Game Over")
                alert.setMessage("Let's see if you're ready...")
                alert.setPositiveButton("Yes") { dialog, which ->

                    if (score >= 10) {

                        val intent = Intent(applicationContext, FinishActivity::class.java).apply {
                            putExtra(EXTRA_MESSAGE, name)
                        }
                        startActivity(intent)
                        finish()

                    } else {

                        val intent = Intent(applicationContext, GameActivity3::class.java).apply {
                            putExtra(EXTRA_MESSAGE, name)
                        }
                        startActivity(intent)
                        Toast.makeText(applicationContext, "You're not ready yet.", Toast.LENGTH_LONG).show()
                        finish()

                    }

                }

                alert.setNegativeButton("No") { dialog, which ->
                    val intent = Intent(applicationContext, IntroductionActivity::class.java)
                    startActivity(intent)
                }
                alert.show()

                Toast.makeText(applicationContext, "Well done Avenger!", Toast.LENGTH_LONG).show()

            }

        }.start()
    }

    private fun hideImages() {
        runnable = Runnable {
            for (image in imageArray) {
                image.visibility = View.INVISIBLE
            }

            val random = Random()
            val randomIndex = random.nextInt(16)
            imageArray[randomIndex].visibility = View.VISIBLE
            handler.postDelayed(runnable, 500)
        }
        handler.post(runnable)
    }

    fun increaseScore(view: View) {
        score += 1
        scoreText.text = "Score: $score"
    }

}