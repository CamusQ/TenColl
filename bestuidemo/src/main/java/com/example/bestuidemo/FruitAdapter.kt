package com.example.bestuidemo

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FruitAdapter(fruit: ArrayList<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {
    var fruitList = ArrayList<Fruit>()
    var context: Context? = null

    init {
        fruitList = fruit
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("TAG","onCreateViewHolder")
        if (context == null) {
            context = parent.context
        }

        var view = LayoutInflater.from(context).inflate(R.layout.fruit_item, parent, false)

        var holder = ViewHolder(view)
        holder.cardView.setOnClickListener {
            Log.d("TAG","holder.cardView.setOnClickListener")

            var positioin = holder.adapterPosition
            var fruit = fruitList.get(positioin)
            var intent = Intent(context,FruitActivity::class.java)
            intent.putExtra(FruitActivity.FRUIT_NAME,fruit.name)
            intent.putExtra(FruitActivity.FRUIT_IAMGE_ID,fruit.imageId)
            context?.startActivity(intent)
        }

        return holder
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("TAG","onBindViewHolder")
        var fruit = fruitList.get(position)
        holder.fruitName.text = fruit.name
        Glide.with(context).load(fruit.imageId).into(holder.fruitImage)
    }

    class ViewHolder : RecyclerView.ViewHolder {
        var cardView: CardView
        var fruitImage: ImageView
        var fruitName: TextView

        constructor(itemView: View) : super(itemView) {
            cardView = itemView as CardView
            fruitImage = itemView.findViewById<ImageView>(R.id.fruit_imageId)
            fruitName = itemView.findViewById<TextView>(R.id.fruit_name)
        }
    }
}