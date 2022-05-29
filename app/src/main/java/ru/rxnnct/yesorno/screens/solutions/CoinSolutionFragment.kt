package ru.rxnnct.yesorno.screens.solutions

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.viewModels
import ru.rxnnct.yesorno.R
import ru.rxnnct.yesorno.YesOrNoApplication
import ru.rxnnct.yesorno.screens.hideKeyboard

class CoinSolutionFragment : BaseSolutionFragment(R.layout.fragment_coin_solution) {

    private lateinit var headQuestionEditText: EditText
    private lateinit var tailQuestionEditText: EditText
    private lateinit var headQuestionText: TextView
    private lateinit var tailQuestionText: TextView

    private val coinSolutionViewModel: CoinSolutionViewModel by viewModels {
        CoinSolutionViewModelFactory((activity?.application as YesOrNoApplication).solutionResultRepository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        headQuestionEditText = fragmentView.findViewById(R.id.question_head)
        tailQuestionEditText = fragmentView.findViewById(R.id.question_tail)
        headQuestionText = fragmentView.findViewById(R.id.question_head_text)
        tailQuestionText = fragmentView.findViewById(R.id.question_tail_text)


        headQuestionEditText.addTextChangedListener(object: TextWatcher {
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

        tailQuestionEditText.addTextChangedListener(object: TextWatcher {
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
        coinSolutionViewModel.headQuestion = headQuestionEditText.text.toString()
        coinSolutionViewModel.tailQuestion = tailQuestionEditText.text.toString()
        coinSolutionViewModel.solve()
        updateUiToSolved()
    }

    override fun onNext() {
        coinSolutionViewModel.next()
        updateUiToNext()
    }

    override fun updateUiToSolved() {
        resultTextView.text = coinSolutionViewModel.result

        headQuestionEditText.visibility = View.GONE
        tailQuestionEditText.visibility = View.GONE
        headQuestionText.visibility = View.GONE
        tailQuestionText.visibility = View.GONE
        solveButton.visibility = View.GONE
        resultTextView.visibility = View.VISIBLE
        nextButton.visibility = View.VISIBLE

        fragmentView.hideKeyboard()
    }

    override fun updateUiToNext() {
        headQuestionEditText.text.clear()
        tailQuestionEditText.text.clear()

        headQuestionEditText.visibility = View.VISIBLE
        tailQuestionEditText.visibility = View.VISIBLE
        headQuestionText.visibility = View.VISIBLE
        tailQuestionText.visibility = View.VISIBLE
        solveButton.visibility = View.VISIBLE
        resultTextView.visibility = View.GONE
        nextButton.visibility = View.GONE
    }
}