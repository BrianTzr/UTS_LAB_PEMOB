package com.example.uts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var card: CardData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Retrieve the card data from the intent
        card = intent.getSerializableExtra("card") as CardData

        val cardImage = findViewById<ImageView>(R.id.cardImage)
        val cardName = findViewById<TextView>(R.id.cardName)
        val cardDesc = findViewById<TextView>(R.id.cardDesc)
        val cardType = findViewById<TextView>(R.id.cardType)
        val cardRace = findViewById<TextView>(R.id.cardRace)
        val cardArchetype = findViewById<TextView>(R.id.cardArchetype)
        val cardLink = findViewById<TextView>(R.id.cardLink)

        // Load the image using Glide
        Glide.with(cardImage.context)
            .load(card.card_images[0].image_url_cropped)
            .into(cardImage)

        // Set the TextViews with card data
        cardName.text = Html.fromHtml("<u>${card.name}</u>")
        cardDesc.text = card.desc
        cardType.text = "Card Type: ${card.type} / ${card.humanReadableCardType}"
        cardRace.text = "Race     : ${card.race}"
        cardArchetype.text = "Archetype: ${card.archetype}"

        // Set the link text and make it clickable
        cardLink.text = card.ygoprodeck_url
        cardLink.setOnClickListener {
            val uri = Uri.parse(card.ygoprodeck_url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}
