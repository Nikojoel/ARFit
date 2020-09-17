package com.example.arfit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.shoe_cell.view.*

const val EXTRA_MESSAGE = "shoe data"

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
    }

    private fun initRecycler() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerViewAdapter = RecyclerAdapter(this@MainActivity, ShoeModel.shoes)
            adapter = recyclerViewAdapter
        }
    }

    private fun startIntent(shoe: String) {
        val intent = Intent(this, ArActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, shoe)
        }
        startActivity(intent)
    }

    private inner class RecyclerAdapter(private val context: Context, private val shoes: List<Shoe>): RecyclerView.Adapter<ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(context).inflate(R.layout.shoe_cell, parent, false)
            return ViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.itemView.shoeName.text = shoes[position].name
            holder.itemView.shoeRetailer.text = shoes[position].retailer
            holder.itemView.shoePrice.text = shoes[position].price
            holder.itemView.shoePic.setImageResource(shoes[position].imgPath)

            holder.itemView.tryButton.setOnClickListener {
                startIntent(shoes[position].name)
            }
        }

        override fun getItemCount() = shoes.size
    }
}


class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
}

