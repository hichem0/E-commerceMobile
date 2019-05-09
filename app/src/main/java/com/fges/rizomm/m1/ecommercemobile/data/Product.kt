package com.fges.rizomm.m1.ecommercemobile.data

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("designation")
    val title: String,

    @SerializedName("photo")
     val photoUrl: String,

    @SerializedName("prix")
    val price : Double) {
}