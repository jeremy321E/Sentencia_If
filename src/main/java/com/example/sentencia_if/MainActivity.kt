package com.example.sentencia_if

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gradeInput: EditText = findViewById(R.id.gradeInput)
        val checkButton: Button = findViewById(R.id.checkButton)
        val resultText: TextView = findViewById(R.id.resultText)

        checkButton.setOnClickListener {
            val grade = gradeInput.text.toString().toIntOrNull()

            if (grade != null) {
                val letterGrade = when {
                    grade in 90..100 -> "A"
                    grade in 80..89 -> "B"
                    grade in 70..79 -> "C"
                    grade in 60..69 -> "D"
                    else -> "F"
                }

                val resultMessage = if (grade >= 70) {
                    "¡Felicidades! Aprobaste el examen con una calificación de $letterGrade."
                } else {
                    "Lo siento, reprobaste el examen con una calificación de $letterGrade."
                }

                resultText.text = resultMessage
            } else {
                resultText.text = "Por favor, ingrese una calificación válida."
            }
        }
    }
}