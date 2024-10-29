package com.example.uts

import java.io.Serializable

data class ApiResponse(
    val data: List<CardData>
)

data class CardData(
    val id: Long,
    val name: String,
    val type: String,
    val humanReadableCardType: String,
    val frameType: String,
    val desc: String,
    val race: String,
    val archetype: String,
    val ygoprodeck_url: String,
    val card_sets: List<CardSet>,
    val card_images: List<CardImage>,
    val card_prices: List<CardPrice>
): Serializable

data class CardSet(
    val set_name: String,
    val set_code: String,
    val set_rarity: String,
    val set_rarity_code: String,
    val set_price: String
): Serializable

data class CardImage(
    val id: Long,
    val image_url: String,
    val image_url_small: String,
    val image_url_cropped: String
): Serializable

data class CardPrice(
    val cardmarket_price: String,
    val tcgplayer_price: String,
    val ebay_price: String,
    val amazon_price: String,
    val coolstuffinc_price: String
): Serializable
