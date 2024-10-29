package com.example.uts

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity: AppCompatActivity() {

    private lateinit var card: CardData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        card = intent.getSerializableExtra("card") as CardData

        val cardImage = findViewById<ImageView>(R.id.cardImage)
        val cardName = findViewById<TextView>(R.id.cardName)
        val cardDesc = findViewById<TextView>(R.id.cardDesc)
//        val cardType = findViewById<TextView>(R.id.cardType)
//        val cardRace = findViewById<TextView>(R.id.cardRace)
//        val cardLink = findViewById<TextView>(R.id.cardLink)

        Glide.with(cardImage.context)
            .load(card.card_images[0].image_url_cropped)
            .into(cardImage)
        cardName.text = card.name
        cardDesc.text = card.desc
//        cardType.text = card.type
//        cardRace.text = card.race
//        cardLink.text = card.ygoprodeck_url
    }
}