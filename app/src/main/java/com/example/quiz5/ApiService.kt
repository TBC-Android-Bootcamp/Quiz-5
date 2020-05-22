package com.example.quiz5

import retrofit2.Call
import retrofit2.http.GET
import java.util.*

interface ApiService {
    @GET("5ec3ab0f300000850039c29e")
    fun getBands() : Call<List<BandModelItem>>

    @GET("5ec3ca1c300000e5b039c407")
    fun getSongs() : Call<List<SongsModel.Songs>>
}