package com.example.tourtravelfrontend

import com.google.gson.annotations.SerializedName

data class ResponseDataPaketTravel(
    @SerializedName("status") val stt:String,
    val totaldata: Int,
    val data:List<PaketTravelData>
)