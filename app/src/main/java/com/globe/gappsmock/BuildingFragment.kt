package com.globe.gappsmock

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.*
import android.widget.Toast
import android.widget.Adapter




class BuildingFragment : Fragment(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //get list from res/values
        val floors = resources.getStringArray(R.array.floors)
        // get id of spinner
        val dropDown = view?.findViewById<Spinner>(R.id.dropFloors)
        //get the list of string to an adapter for dropDown(Spinner)
        val adapter = activity?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.floors,
                android.R.layout.simple_spinner_item
            )
                ?.also { adapter ->
                    // Specify the layout to use when the list of choices appears
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    // Apply the adapter to the spinner
                    if (dropDown != null) {
                        dropDown.adapter = adapter
                    }
                }
        }







            /*dropDown.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    println("helloooo")
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
                }*/


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_building, container, false)
    }
}