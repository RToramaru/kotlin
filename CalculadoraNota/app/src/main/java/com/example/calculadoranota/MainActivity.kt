package com.example.calculadoranota

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextPaint
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular = findViewById<Button>(R.id.calcular)
        val resultadoTexto = findViewById<TextView>(R.id.textView)

        btnCalcular.setOnClickListener {
            var aux = findViewById<EditText>(R.id.editTextTextPersonNota1)
            val nota1 = Integer.parseInt(aux.text.toString())

            aux = findViewById<EditText>(R.id.editTextTextPersonNota2)
            val nota2 = Integer.parseInt(aux.text.toString())

            aux = findViewById<EditText>(R.id.editTextTextPersonFalta)
            val falta = Integer.parseInt(aux.text.toString())

            val media = (nota1 + nota2) / 2

            if(media >= 6 && falta <= 10){
                resultadoTexto.setText("Aluno foi aprovado")
                resultadoTexto.setTextColor(Color.GREEN)
            } else{
                resultadoTexto.setText("Aluno reprovado")
                resultadoTexto.setTextColor(Color.RED)
            }


        }
    }
}