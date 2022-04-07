package ru.rxnnct.yesorno.screens.solutions

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.rxnnct.yesorno.R

class YesNoSolutionFragment: Fragment(R.layout.fragment_yes_no_solution) {

    private lateinit var viewModel: YesNoSolutionViewModel
    private lateinit var fragmentView: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(YesNoSolutionViewModel::class.java)
        fragmentView = view

        view.findViewById<Button>(R.id.solve).setOnClickListener{ onSolve() }
        view.findViewById<Button>(R.id.next).setOnClickListener{ onNext() }
    }

    private fun onSolve() {
        viewModel.onSolve()
        updateUiToSolved()
    }

    private fun onNext() {
        viewModel.onNext()
        updateUiToNext()
    }

    private fun updateUiToSolved() {
        fragmentView.findViewById<EditText>(R.id.question).visibility = View.GONE
        fragmentView.findViewById<Button>(R.id.solve).visibility = View.GONE
        fragmentView.findViewById<TextView>(R.id.result).visibility = View.VISIBLE
        fragmentView.findViewById<Button>(R.id.next).visibility = View.VISIBLE
    }

    private fun updateUiToNext() {
        fragmentView.findViewById<EditText>(R.id.question).visibility = View.VISIBLE
        fragmentView.findViewById<Button>(R.id.solve).visibility = View.VISIBLE
        fragmentView.findViewById<TextView>(R.id.result).visibility = View.GONE
        fragmentView.findViewById<Button>(R.id.next).visibility = View.GONE
    }

}