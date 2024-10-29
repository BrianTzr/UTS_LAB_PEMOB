package com.example.uts

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("cardinfo.php") // replace with actual endpoint as needed
    fun getAllCardData(): Call<ApiResponse>

    @GET("cardinfo.php?name=Dark Magician")
    fun getDarkMagician(): Call<ApiResponse>

    @GET("cardinfo.php?archetype=Blue-Eyes")
    fun getBlueEyes(): Call<ApiResponse>

}
