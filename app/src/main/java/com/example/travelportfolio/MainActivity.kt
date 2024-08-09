package com.example.travelportfolio

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image: ImageView
    var places = arrayOf("Faisal Mosque", "Badshahi Mosque", "Rome", "Taj Mehal")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nextButton = findViewById<ImageButton>(R.id.btnNext)
        val prevButton = findViewById<ImageButton>(R.id.btnPrev)
        val textView = findViewById<TextView>(R.id.txtPlace)

        nextButton.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"

            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (4 + currentImage + 1) % 4

            var idImagetoShow = "pic$currentImage"
            var idImagetoShowInt = this.resources.getIdentifier(idImagetoShow, "id", packageName)
            image = findViewById(idImagetoShowInt)
            image.alpha = 1f

            textView.text = places[currentImage]

        }

        prevButton.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"

            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (4 + currentImage - 1) % 4

            var idImagetoShow = "pic$currentImage"
            var idImagetoShowInt = this.resources.getIdentifier(idImagetoShow, "id", packageName)
            image = findViewById(idImagetoShowInt)
            image.alpha = 1f

            textView.text = places[currentImage]
        }
    }
}