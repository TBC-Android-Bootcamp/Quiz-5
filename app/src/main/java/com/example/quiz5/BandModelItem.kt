package com.example.quiz5


import com.google.gson.annotations.SerializedName

data class BandModelItem(
    @SerializedName("genre")
    val genre: String,
    @SerializedName("img_url")
    val imgUrl: String,
    @SerializedName("info")
    val info: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("thumb1")
    val thumb1: String,
    @SerializedName("thumb2")
    val thumb2: String,
    @SerializedName("thumb3")
    val thumb3: String,

    var bandSongs: ArrayList<SongsModel>
)