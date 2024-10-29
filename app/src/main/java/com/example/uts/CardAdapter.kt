package com.example.uts

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CardAdapter(
    private val context: Context,
    private val cardList: List<CardData>
) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardImage: ImageView = itemView.findViewById(R.id.cardImage)
        val cardName: TextView = itemView.findViewById(R.id.cardName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        Log.d("CardAdapter", "Card: ${cardList[0]}")
        val card = cardList[position]
        holder.cardName.text = card.name

        // Load image using Glide (you'll need to add Glide dependency in build.gradle)
        Glide.with(holder.cardImage.context)
            .load(card.card_images[0].image_url)
            .into(holder.cardImage)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("card", card)
            context.startActivity(intent)
        }

    }

    override fun getItemCount() = cardList.size
}
