package com.akshay.evaluation9.model

object CardList {

    fun loadOffers():List<OfferModel>{
        return listOf(
            OfferModel(title = "100 Credits Prize/Ticket Game Card"),
            OfferModel(title = "Card with Coke"),
            OfferModel(title = "New Birthday Card"),
            OfferModel(title = "Birthday game card with Discount"),
            OfferModel(title = "Birthday game card with 10% discount")
        )
    }
}