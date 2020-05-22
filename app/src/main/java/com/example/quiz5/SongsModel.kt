package com.example.quiz5


import com.google.gson.annotations.SerializedName

class SongsModel (val band: String, val song:ArrayList<Songs>){
    class Songs(val title: String)
}