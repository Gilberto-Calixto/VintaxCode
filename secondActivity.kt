package com.example.vintax

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class secondActivity : AppCompatActivity() {

    private lateinit
    var rcyv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id = 1,
                drawableId = R.drawable.baseline_diamond_24,
                textStringId = R.string.titlenam,
                color = Color.GREEN
            )
        )
        mainItems.add(
            MainItem(
                id = 2,
                drawableId = R.drawable.baseline_flare_24,
                textStringId = R.string.geradir,
                color = Color.CYAN
            )
        )
        rcyv = findViewById(R.id.rcyV)
        val adapter = MainAdapter(mainItems)
        rcyv.adapter = adapter
        rcyv.layoutManager = LinearLayoutManager(this)
    }

    private inner class MainAdapter(private val mainItems : List<MainItem>) : RecyclerView.Adapter<MainViewHolder>() {

        //O layout da célula específica (item)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.item_icon, parent, false)
            return MainViewHolder(view)
        }

        //Quantas céulas essa listagem terá
        override fun getItemCount(): Int {
            return mainItems.size
        }

        //Dispara toda vez que houver uma rolalgem na tela se for preciso trocar o conteúdo
        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val itemCurrent = mainItems[position]
            holder.bind(itemCurrent)
        }

    }

    private class MainViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(item: MainItem){
            val imgg : ImageView = itemView.findViewById(R.id.imgTest)
            val name : TextView = itemView.findViewById(R.id.text_Icon)
            val btc_and : LinearLayout = itemView as LinearLayout

            imgg.setImageResource(item.drawableId)
            name.setText(item.textStringId)
            btc_and.setBackgroundColor(item.color)

        }
    }
}