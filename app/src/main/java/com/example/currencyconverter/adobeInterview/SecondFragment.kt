package com.example.currencyconverter.adobeInterview

import android.animation.Animator
import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import com.example.currencyconverter.R

class SecondFragment: Fragment() {

    override fun onInflate(context: Context, attrs: AttributeSet, savedInstanceState: Bundle?) {
        Log.i("Activty B Fragment", "onInflate" )
        super.onInflate(context, attrs, savedInstanceState)
    }

    override fun onInflate(Activty: Activity, attrs: AttributeSet, savedInstanceState: Bundle?) {
        Log.i("Activty B Fragment", "onInflate" )

        super.onInflate(Activty, attrs, savedInstanceState)
    }

    override fun onAttachFragment(childFragment: Fragment) {
        Log.i("Activty B Fragment", "onAttachFragment" )

        super.onAttachFragment(childFragment)
    }

    override fun onAttach(context: Context) {
        Log.i("Activty B Fragment", "onAttach" )

        super.onAttach(context)
    }

    override fun onAttach(Activty: Activity) {
        Log.i("Activty B Fragment", "onAttach" )

        super.onAttach(Activty)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("Activty B Fragment", "onCreate" )

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("Activty B Fragment", "onCreateView" )

        return inflater.inflate(R.layout.fragment_foo, null);
//        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("Activty B Fragment", "onViewCreated" )

        super.onViewCreated(view, savedInstanceState)
    }

    override fun getView(): View? {
        Log.i("Activty B Fragment", "getView" )

        return super.getView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i("Activty B Fragment", "onActivtyCreated" )

        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        Log.i("Activty B Fragment", "onViewStateRestored" )

        super.onViewStateRestored(savedInstanceState)
    }

    override fun onStart() {
        Log.i("Activty B Fragment", "onStart" )

        super.onStart()
    }

    override fun onResume() {
        Log.i("Activty B Fragment", "onResume" )

        super.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("Activty B Fragment", "onSaveInstanceState" )

        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        Log.i("Activty B Fragment", "onPause" )

        super.onPause()
    }

    override fun onStop() {
        Log.i("Activty B Fragment", "onStop" )

        super.onStop()
    }

    override fun onDestroyView() {
        Log.i("Activty B Fragment", "onDestroyView" )

        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.i("Activty B Fragment", "onDestroy" )

        super.onDestroy()
    }

    override fun onDetach() {
        Log.i("Activty B Fragment", "onDetach" )

        super.onDetach()
    }
}