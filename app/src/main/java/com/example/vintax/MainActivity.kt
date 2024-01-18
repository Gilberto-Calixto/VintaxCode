package com.example.vintax

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = getSharedPreferences("ad", Context.MODE_PRIVATE)

        val imagemTomi : ImageView = findViewById(R.id.imageView)
        imagemTomi.setImageResource(R.drawable.tomioka)

        val texNum: EditText = findViewById(R.id.emIText)
        val bost: Button = findViewById(R.id.button_gerator)
        val rest : TextView = findViewById(R.id.totName)

        val buttInt : Button = findViewById(R.id.intent)


        val result = prefs.getString("result", null)
        result?.let {
            rest.text = "Ultima apopsta: $it"
        }

        bost.setOnClickListener{

            val txt = texNum.text.toString()
            geratorClick(txt, rest)

        }

        buttInt.setOnClickListener {
            val intent = Intent(this, secondActivity::class.java)
            startActivity(intent)
        }
    }
    private fun geratorClick(text : String, rest : TextView  ) {

        if (text.isEmpty()) {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle(getString(R.string.falaNumber, 10))
                .setMessage(android.R.string.cancel)
                .setPositiveButton(android.R.string.ok){dialog, wich ->

                }
            val d = dialog.create()
            d.show()

            //enconder o teclado após o uso
            val service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            service.hideSoftInputFromWindow(currentFocus?.windowToken,0)
            return
        }
        val qtd = text.toInt()
        if(qtd < 6 || qtd > 15){
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle(R.string.falaEmpyt)
            dialog.setMessage(R.string.falaNumber)
            dialog.setPositiveButton(android.R.string.ok){ dialog,
                                                           wich ->
                }
            val d = dialog
            d.show()
            return
        }

        val numbers = mutableSetOf<Int>()
        val random = Random

        while(true){

            val number = random.nextInt(60)
            numbers.add( number + 1)
            if(numbers.size == qtd){
                break
            }
        }
        rest.text = numbers.joinToString(" - ")

        prefs.edit().apply{
            putString("result", rest.text.toString())
            apply()
        }

        }
    }
