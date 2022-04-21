package ru.rxnnct.yesorno.screens.solutions

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.rxnnct.yesorno.R
import ru.rxnnct.yesorno.YesOrNoApplication
import ru.rxnnct.yesorno.screens.hideKeyboard


class YesNoSolutionFragment : Fragment(R.layout.fragment_yes_no_solution) {

    private val yesNoSolutionViewModel: YesNoSolutionViewModel by viewModels {
        YesNoSolutionViewModelFactory((activity?.application as YesOrNoApplication).solutionResultRepository)
    }

    private lateinit var fragmentView: View

    private lateinit var resultTextView: TextView
    private lateinit var questionEditText: EditText
    private lateinit var solveButton: Button
    private lateinit var nextButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentView = view
        resultTextView = fragmentView.findViewById(R.id.result)
        questionEditText = fragmentView.findViewById(R.id.question)
        solveButton = fragmentView.findViewById(R.id.solve)
        nextButton = fragmentView.findViewById(R.id.next)

        solveButton.setOnClickListener { onSolve() }
        nextButton.setOnClickListener { onNext() }

        questionEditText.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int) {
                solveButton.isEnabled = s.toString().trim { it <= ' ' }.isNotEmpty()
            }
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int) {
                // TODO Auto-generated method stub
            }
            override fun afterTextChanged(s: Editable) {
                // TODO Auto-generated method stub
            }
        })
    }

    private fun onSolve() {
        yesNoSolutionViewModel.question = questionEditText.text.toString()
        yesNoSolutionViewModel.onSolve()
        updateUiToSolved()
    }

    private fun onNext() {
        yesNoSolutionViewModel.onNext()
        updateUiToNext()
    }

    private fun updateUiToSolved() {
        resultTextView.text = yesNoSolutionViewModel.result

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