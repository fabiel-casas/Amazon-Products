package com.fabiel.casas.amazon_products.data.models

data class Product(
    val USPs: List<String>,
    val availabilityState: Int,
    val coolbluesChoiceInformationTitle: String,
    val nextDayDelivery: Boolean,
    val productId: Int,
    val productImage: String,
    val productName: String,
    val promoIcon: PromoIcon,
    val reviewInformation: ReviewInformation,
    val salesPriceIncVat: Float
)