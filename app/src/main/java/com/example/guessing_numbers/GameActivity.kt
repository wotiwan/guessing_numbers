package com.example.guessing_numbers

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameActivity : AppCompatActivity() {
    var left: Int = 0
    var right: Int = 100
    lateinit var yourNumberString: TextView
    lateinit var numberText: CharSequence
    lateinit var finalGuess: CharSequence
    lateinit var result: CharSequence
    lateinit var yes_btn: View
    lateinit var no_btn: View
    var temp = (right - left) / 2 + left

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        left = intent.getIntExtra("left", 0)
        right = intent.getIntExtra("right", 0)

        temp = (right - left) / 2 + left
        yourNumberString = findViewById(R.id.number_is)
        numberText = resources.getText(R.string.number_greater_than)
        finalGuess = resources.getText(R.string.final_guess)
        result = resources.getText(R.string.result)

        yes_btn = findViewById<Button>(R.id.yes)
        no_btn = findViewById<Button>(R.id.no)

        yourNumberString.text = "${numberText} ${temp}"
    }

    fun onYesNoClick(view: View) {
        when (view.id) {
            R.id.yes -> {
                left = temp
            }
            R.id.no -> {
                right = temp
            }
        }
        if (right - left == 2) {
            temp = (right - left) / 2 + left
            yourNumberString.text = "${finalGuess} ${right}"
        } else if (right - left <= 1) {
            yourNumberString.text = "${result} ${right}"
            yes_btn.visibility = View.GONE
            no_btn.visibility = View.GONE
        } else {
            temp = (right - left) / 2 + left
            yourNumberString.text = "${numberText} ${temp}"
        }
    }
}