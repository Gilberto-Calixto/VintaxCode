package com.example.vintax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class secondActivity : AppCompatActivity() {

    private lateinit
    var rcyv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        rcyv = findViewById(R.id.rcyV)
        val adapter = MainAdapter()
        rcyv.adapter = adapter
        rcyv.layoutManager = LinearLayoutManager(this)
    }

    private inner class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

        //O layout da célula específica (item)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.item_icon, parent, false)
            val viewHolder = MainViewHolder(view)
            return viewHolder

        }

        //Quantas céulas essa listagem terá
        override fun getItemCount(): Int {
            return 20
        }

        //Dispara toda vez que houver uma rolalgem na tela se for preciso trocar o conteúdo
        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            //
        }

    }

    private class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}