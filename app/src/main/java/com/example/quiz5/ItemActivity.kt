package com.example.quiz5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_item.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.song_item_layout.*
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ItemActivity : AppCompatActivity() {

    private var songs = ArrayList<SongsModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://www.mocky.io/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.getSongs().enqueue(object : Callback<List<SongsModel.Songs>> {
            override fun onResponse(call: Call<List<SongsModel.Songs>>, response: Response<List<SongsModel.Songs>>) {
                Log.d("bacho", "onResponse ${response.body()!![0]}")

            }
            override fun onFailure(call: Call<List<SongsModel.Songs>>, t: Throwable) {
                Log.d("bacho", "onFailure")
            }
        })
        init()
    }

    private fun init() {
        val getName = intent.extras?.getString("name", "")
        val getInfo = intent.extras?.getString("information", "")
        name.text = getName.toString()
        bandInfo.text = getInfo.toString()

        val title1 = intent.extras?.getString("song1")
        val title2 = intent.extras?.getString("song2")
        val title3 = intent.extras?.getString("song3")

        song1.text = title1
        song2.text = title2
        song3.text = title3

        song1.setOnClickListener{
            Toast.makeText(this, song1.text, Toast.LENGTH_SHORT).show()
        }

        song2.setOnClickListener{
            Toast.makeText(this, song2.text, Toast.LENGTH_SHORT).show()
        }

        song3.setOnClickListener{
            Toast.makeText(this, song2.text, Toast.LENGTH_SHORT).show()
        }
    }

}
