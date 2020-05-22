package com.example.quiz5

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class RecyclerViewAdapter(
    private val bands: List<BandModelItem>,
    private val activity: MainActivity
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun getItemCount() = bands.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val band = bands[position]
        holder.name.text = band.name
        Glide.with(activity).load(band.imgUrl).into(holder.image)
        holder.image.setOnClickListener {
            val intent = Intent(activity, ItemActivity::class.java)
            intent.putExtra("name", band.name)
            intent.putExtra("information", band.info)
            if(band.name == "Led Zeppelin"){
                intent.putExtra("song1", "In the Evening")
                intent.putExtra("song2", "Traveling Riverside Blues")
                intent.putExtra("song3", "Since I’ve Been Loving You")
            }
            if(band.name == "The Beatles") {
                intent.putExtra("song1", "Hey Jude")
                intent.putExtra("song2", "All My Loving")
                intent.putExtra("song3", "All Together Now")
            }

            if(band.name == "Pink Floyd") {
                intent.putExtra("song1", "Absolutely Curtains")
                intent.putExtra("song2", "Atom Heart Mother")
                intent.putExtra("song3", "Blues")
            }

            if(band.name == "Queen") {
                intent.putExtra("song1", "Brighton Rock")
                intent.putExtra("song2", "Bijou")
                intent.putExtra("song3", "Coming Soon")
            }

            if(band.name == "Metallica") {
                intent.putExtra("song1", "Bad Seed")
                intent.putExtra("song2", "The Call of Ktulu")
                intent.putExtra("song3", "Hell and Back")
            }

            if(band.name == "AC/DC") {
                intent.putExtra("song1", "Boogie Man")
                intent.putExtra("song2", "Love Bomb")
                intent.putExtra("song3", "Bedlam In Belgium")
            }

            activity.startActivity(intent)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.tvName
        val image: ImageView = itemView.bandImage
    }
}