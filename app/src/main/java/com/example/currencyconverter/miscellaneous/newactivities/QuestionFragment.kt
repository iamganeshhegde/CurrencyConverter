package com.example.currencyconverter.miscellaneous.newactivities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.currencyconverter.R
import kotlinx.android.synthetic.main.fragment_question.view.*

class QuestionFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView( //the fragment is initialized and bound to the nav host activity.
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_question, container, false)

        root.yesbutton.setOnClickListener {view:View->
            Navigation.findNavController(view).navigate(R.id.action_questionFragment_to_correctFargment)
        }

        root.nobutton.setOnClickListener {view:View->
            Navigation.findNavController(view).navigate(R.id.action_questionFragment_to_wrongFragment)
        }
        return root //return the main UI
    }

}
