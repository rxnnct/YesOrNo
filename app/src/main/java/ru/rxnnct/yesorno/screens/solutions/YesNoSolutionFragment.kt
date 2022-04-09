package ru.rxnnct.yesorno.screens.solutions

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.rxnnct.yesorno.R
import ru.rxnnct.yesorno.screens.hideKeyboard


class YesNoSolutionFragment : Fragment(R.layout.fragment_yes_no_solution) {

    private lateinit var viewModel: YesNoSolutionViewModel
    private lateinit var fragmentView: View

    private lateinit var resultTextView: TextView
    private lateinit var questionEditText: EditText
    private lateinit var solveButton: Button
    private lateinit var nextButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(YesNoSolutionViewModel::class.java)
        fragmentView = view

        resultTextView = fragmentView.findViewById(R.id.result)
        questionEditText = fragmentView.findViewById(R.id.question)
        solveButton = fragmentView.findViewById(R.id.solve)
        nextButton = fragmentView.findViewById(R.id.next)

        solveButton.setOnClickListener { onSolve() }
        nextButton.setOnClickListener { onNext() }
    }

    private fun onSolve() {
        viewModel.question = fragmentView.findViewById<EditText>(R.id.question).text.toString()
        viewModel.onSolve()
        updateUiToSolved()
    }

    private fun onNext() {
        viewModel.onNext()
        updateUiToNext()
    }

    private fun updateUiToSolved() {
        resultTextView.text = viewModel.result

        questionEditText.visibility = View.GONE
        solveButton.visibility = View.GONE
        resultTextView.visibility = View.VISIBLE
        nextButton.visibility = View.VISIBLE

        fragmentView.hideKeyboard()

    }

    private fun updateUiToNext() {
        questionEditText.text.clear()

        questionEditText.visibility = View.VISIBLE
        solveButton.visibility = View.VISIBLE
        resultTextView.visibility = View.GONE
        nextButton.visibility = View.GONE
    }
}