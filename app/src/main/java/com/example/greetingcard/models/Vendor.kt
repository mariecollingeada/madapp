package com.example.greetingcard.models

data class Vendor(
    val id: Int,
    val title: String,
    val address: String,
    val postcode: String,
    val shortDesc: String,
    val longDesc: String,
    val tierId: Int,
    val vendorTypeId: Int,
    val url: String
)