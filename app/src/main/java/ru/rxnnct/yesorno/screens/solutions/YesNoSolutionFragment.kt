package ru.rxnnct.yesorno.screens.solutions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import ru.rxnnct.yesorno.R
import ru.rxnnct.yesorno.YesOrNoApplication
import ru.rxnnct.yesorno.screens.hideKeyboard


class YesNoSolutionFragment : BaseSolutionFragment(R.layout.fragment_yes_no_solution) {

    private val yesNoSolutionViewModel: YesNoSolutionViewModel by viewModels {
        YesNoSolutionViewModelFactory((activity?.application as YesOrNoApplication).solutionResultRepository)
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