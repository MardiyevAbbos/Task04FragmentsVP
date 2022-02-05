package com.example.usefragmentsvp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.usefragmentsvp.R
import com.example.usefragmentsvp.model.Country

class InfoAdapter(private val countries: ArrayList<Country>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_info_view, parent, false)
        return InfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is InfoViewHolder) {
            val country = countries[position]
            holder.apply {
                info.text = country.info
            }
        }
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    class InfoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val info: TextView = view.findViewById(R.id.tvInfo_infoCountry)
    }

}