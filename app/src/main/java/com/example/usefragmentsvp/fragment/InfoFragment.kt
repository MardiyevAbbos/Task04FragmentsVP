package com.example.usefragmentsvp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.usefragmentsvp.R
import com.example.usefragmentsvp.adapter.InfoAdapter
import com.example.usefragmentsvp.model.Country

class InfoFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val KEY: String = "the_key_info"

    fun newInstance(countries: ArrayList<Country>): InfoFragment {
        val fragment = InfoFragment()
        // set The arguments
        val bundle = Bundle()
        bundle.putSerializable(KEY, countries)

        fragment.arguments = bundle
        return fragment
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info_about_countries, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.rv_infoOf_countries)
        recyclerView.layoutManager = GridLayoutManager(view.context, 1)
        refreshAdapter()
    }

    private fun refreshAdapter() {
        val adapter = InfoAdapter(arguments?.getSerializable(KEY) as ArrayList<Country>)
        recyclerView.adapter = adapter
    }

}