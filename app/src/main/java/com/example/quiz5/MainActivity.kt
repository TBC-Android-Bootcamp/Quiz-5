package com.example.quiz5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl("http://www.mocky.io/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(ApiService::class.java)

        api.getBands().enqueue(object : Callback<List<BandModelItem>> {
            override fun onResponse(call: Call<List<BandModelItem>>, response: Response<List<BandModelItem>>) {
                Log.d("bacho", "onResponse ${response.body()!![0].name}")
                showData(response.body()!!)
            }
            override fun onFailure(call: Call<List<BandModelItem>>, t: Throwable) {
                Log.d("bacho", "onFailure")
            }
        })
    }

    private fun showData(bands: List<BandModelItem>) {
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = RecyclerViewAdapter(bands, this@MainActivity)
        }
    }

}
