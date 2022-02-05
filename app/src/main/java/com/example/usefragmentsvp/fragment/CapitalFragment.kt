package com.example.usefragmentsvp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.usefragmentsvp.R
import com.example.usefragmentsvp.adapter.CapitalAdapter
import com.example.usefragmentsvp.model.Country
import java.security.Key

class CapitalFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val KEY: String = "the_key_capital"

    fun newInstance(countries: ArrayList<Country>): CapitalFragment {
        val fragment = CapitalFragment()
        // set The arguments
        val bundle: Bundle = Bundle()
        bundle.putSerializable(KEY, countries)

        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_capitals_of_countries, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.rv_capitalOf_countries)
        recyclerView.layoutManager = GridLayoutManager(view.context, 1)
        refreshAdapter()
    }

    private fun refreshAdapter() {
        val adapter = CapitalAdapter(arguments?.getSerializable(KEY) as ArrayList<Country>)
        recyclerView.adapter = adapter
    }

}