package com.example.tourtravelfrontend

import com.google.gson.annotations.SerializedName

data class PaketTravelData (
    @SerializedName("idPaket") val idPaket:String,
    @SerializedName("namaPaket") val namaPaket:String,
    @SerializedName("tujuan") val tujuan:String,
    @SerializedName("asal") val asal:String,
    @SerializedName("harga") val harga:String,
    @SerializedName("jam") val jam:String,
    @SerializedName("durasi") val durasi:String,
)