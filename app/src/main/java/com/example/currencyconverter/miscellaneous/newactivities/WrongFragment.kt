package com.example.currencyconverter.miscellaneous.newactivities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.currencyconverter.R
import kotlinx.android.synthetic.main.fragment_wrong.view.*

class WrongFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_wrong, container, false)
        // we access the widget's id using the application's root.
        root.tryagain.setOnClickListener {view:View->
            Navigation.findNavController(view).navigate(R.id.action_wrongFragment_to_questionFragment)
            //we use the findNavController to navigate across different fragments
        }

        return root; //return main ui
    }
}