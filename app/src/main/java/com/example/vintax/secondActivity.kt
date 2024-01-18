package com.example.vintax

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
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
                textStringId = R.string.Imcc,
                color = Color.GREEN
            )
        )
        mainItems.add(
            MainItem(
                id = 2,
                drawableId = R.drawable.baseline_filter_drama_24,
                textStringId = R.string.app_name,
                color = Color.MAGENTA
            )
        )

        rcyv = findViewById(R.id.rcyV)
        val adapter = MainAdapter(mainItems) { id ->
            when (id) {
                1 -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                2-> {
                    val dialog = AlertDialog.Builder(this)
                        .setTitle("Atenção")
                        .setMessage("OlokoMM")
                        .setPositiveButton(
                            "Ok") {
                                dialog, wich ->
                        }
                    val d = dialog
                    d.show()
                }
            }
        }
        rcyv.adapter = adapter
        rcyv.layoutManager = GridLayoutManager(this, 2)
    }


    private inner class MainAdapter(
        private val mainItems: List<MainItem>,
        //private val OnclickListener: OnitemClickLiatener
        private val OnClickListener: (Int) -> Unit,
    ) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

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

        private inner class MainViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
            fun bind(item: MainItem) {
                val imgg: ImageView = itemView.findViewById(R.id.imgTest)
                val textt: TextView = itemView.findViewById(R.id.text_Icon)
                val btc_icon: LinearLayout = itemView.findViewById(R.id.butc_And)

                imgg.setImageResource(item.drawableId)
                textt.setText(item.textStringId)
                btc_icon.setBackgroundColor(item.color)

                btc_icon.setOnClickListener {
                    OnClickListener.invoke(item.id)

                }
            }

        }
    }


}