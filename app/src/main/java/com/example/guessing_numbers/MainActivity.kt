package com.example.guessing_numbers

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    fun onGuessClick(view: View) {
        var left = findViewById<EditText>(R.id.start_diapason).text.toString()
        var right = findViewById<EditText>(R.id.end_diapason).text.toString()
        left = if (left.length == 0) "0" else left
        right = if (right.length == 0) "100" else right
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("left", left.toInt())
        intent.putExtra("right", right.toInt())
        startActivity(intent)
    }
}