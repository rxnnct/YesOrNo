package ru.rxnnct.yesorno.screens.solutions

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.fragment.app.viewModels
import ru.rxnnct.yesorno.R
import ru.rxnnct.yesorno.YesOrNoApplication
import ru.rxnnct.yesorno.screens.hideKeyboard


class YesNoSolutionFragment : BaseSolutionFragment(R.layout.fragment_yes_no_solution) {

    private lateinit var questionEditText: EditText

    private val yesNoSolutionViewModel: YesNoSolutionViewModel by viewModels {
        YesNoSolutionViewModelFactory((activity?.application as YesOrNoApplication).solutionResultRepository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionEditText = fragmentView.findViewById(R.id.question)

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

    override fun onSolve() {
        yesNoSolutionViewModel.question = questionEditText.text.toString()
        yesNoSolutionViewModel.solve()
        updateUiToSolved()
    }

    override fun onNext() {
        yesNoSolutionViewModel.next()
        updateUiToNext()
    }

    override fun updateUiToSolved() {
        resultTextView.text = yesNoSolutionViewModel.result

        questionEditText.visibility = View.GONE
        solveButton.visibility = View.GONE
        resultTextView.visibility = View.VISIBLE
        nextButton.visibility = View.VISIBLE

        fragmentView.hideKeyboard()
    }

    override fun updateUiToNext() {
        questionEditText.text.clear()

        questionEditText.visibility = View.VISIBLE
        solveButton.visibility = View.VISIBLE
        resultTextView.visibility = View.GONE
        nextButton.visibility = View.GONE
    }
}