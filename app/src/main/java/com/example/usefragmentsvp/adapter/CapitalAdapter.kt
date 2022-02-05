package com.example.usefragmentsvp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.usefragmentsvp.R
import com.example.usefragmentsvp.model.Country

class CapitalAdapter(private val countries: ArrayList<Country>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_capital_view, parent, false)
        return CapitalViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CapitalViewHolder) {
            val country = countries[position]
            holder.apply {
                nameCountry.text = country.name
                nameCapital.text = country.capital
                flag.setImageResource(country.flag)
            }
        }
    }

    override fun getItemCount(): Int {
        return countries.size
    }


    class CapitalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameCountry: TextView = view.findViewById(R.id.tvCapital_nameOfCountry)
        val nameCapital: TextView = view.findViewById(R.id.tvCapital_nameOfCapital)
        val flag: ImageView = view.findViewById(R.id.ivCapital_imageFlag)
    }

}