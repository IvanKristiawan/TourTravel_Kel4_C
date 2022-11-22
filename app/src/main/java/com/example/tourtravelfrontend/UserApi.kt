package com.example.tourtravelfrontend

import retrofit2.Call
import retrofit2.http.*

interface UserApi {
    @GET("users/{cari}")
    fun getData (@Path("cari") cari:String? = null):
            Call<ResponseDataUser>
    @GET("userEmail/{cari}")
    fun getUserEmail(@Path("cari") cari:String? = null):
            Call<ResponseDataUser>
    @FormUrlEncoded
    @POST("users")
    fun createData(

        @Field("username") username:String?,
        @Field("email") email:String?,
        @Field("password") password:String?,
    ):Call<ResponseCreate>
    @FormUrlEncoded
    @POST("login")
    fun loginData(
        @Field("email") email:String?,
        @Field("password") password:String?,
    ):Call<ResponseCreate>
    @DELETE("users/{userId}")
    fun deleteData(@Path("userId")userId:
                   String?):Call<ResponseCreate>
    @FormUrlEncoded
    @PATCH("user/{mhsnobp}")
    fun updateData(
        @Path("username") username:String?,
        @Field("email") email:String?,
        @Field("password") password:String?,
    ):Call<ResponseCreate>

    @GET("paketTravels/{idPaket}")
    fun getDataPaketTravel(@Path("idPaket") cari:String? = null):
            Call<ResponseDataPaketTravel>
    @GET("paketTravels")
    fun getDataPaketTravelAll():
            Call<ResponseDataPaketTravel>
    @FormUrlEncoded
    @POST("paketTravels")
    fun createDataPaketTravel(
        @Field("idPaket") idPaket:String?,
        @Field("namaPaket") namaPaket:String?,
        @Field("tujuan") tujuan:String?,
        @Field("asal") asal:String?,
        @Field("harga") harga:String?,
        @Field("jam") jam:String?,
        @Field("durasi") durasi:String?,
    ):Call<ResponseCreate>
    @DELETE("paketTravels/{userId}")
    fun deleteDataPaketTravel(@Path("userId")userId:
                   String?):Call<ResponseCreate>
    @FormUrlEncoded
    @PATCH("paketTravels/{mhsnobp}")
    fun updateDataPaketTravel(
        @Path("namaPaket") namaPaket:String?,
        @Field("tujuan") tujuan:String?,
        @Field("asal") asal:String?,
        @Field("harga") harga:String?,
        @Field("jam") jam:String?,
        @Field("durasi") durasi:String?,
    ):Call<ResponseCreate>
}