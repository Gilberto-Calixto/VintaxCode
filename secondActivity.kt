package com.example.vintax

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
                drawableId = R.drawable.tomioka,
                textStringId = R.string.titlenam,
                color = Color.GREEN
            )
        )
        mainItems.add(
            MainItem(
                id = 2,
                drawableId = R.drawable.ic_launcher_background,
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
            val buttonTest : Button = itemView.findViewById(R.id.buttGrid1)
            buttonTest.setText(item.textStringId)
        }
    }
}