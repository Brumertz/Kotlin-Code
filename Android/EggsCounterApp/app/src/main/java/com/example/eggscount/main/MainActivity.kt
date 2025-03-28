package com.example.eggscount.main

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.eggscount.R
import com.example.eggscount.eggscalculator.EggCalculator // Import the EggCalculator class

class MainActivity : AppCompatActivity() {

    // Declare an instance of EggCalculator
    private val eggCalculator = EggCalculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputEggs: EditText = findViewById(R.id.inputEggs)
        val resultText: TextView = findViewById(R.id.resultText)
        val calculateButton: Button = findViewById(R.id.calculateButton)

        calculateButton.setText(R.string.calculate_button_text) // Using string resource for button text

        calculateButton.setOnClickListener {
            val eggs = inputEggs.text.toString().toIntOrNull() ?: 0

            // Use the EggCalculator class to calculate gross, dozen, and unit
            val (gross, dozen, unit) = eggCalculator.calculateEggs(eggs)

            // Format the result using the string resource and display it
            val result = getString(R.string.egg_count_result_format, gross, dozen, unit)
            resultText.text = result
        }
    }
}
