package com.example.guessthecolor

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonChangeColor = findViewById<Button>(R.id.changeColorButton)
        val defaultButton = findViewById<Button>(R.id.defaultBtn)
        val backgroundChange = findViewById<LinearLayout>(R.id.main)

        buttonChangeColor.setOnClickListener {
            backgroundChange.setBackgroundColor(ColorGenerator())
        }

        defaultButton.setOnClickListener {
            backgroundChange.setBackgroundColor(Color.WHITE)
        }
    }

    private fun ColorGenerator(): Int {
        val random = (0..16777215).random()
        return Color.rgb(
            (random shr 16) and 0xFF,
            (random shr 8) and 0xFF,
            random and 0xFF
        )
    }
}
