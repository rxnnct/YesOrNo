package ru.rxnnct.yesorno.screens.solutions

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import ru.rxnnct.yesorno.R

abstract class BaseSolutionFragment(@LayoutRes contentLayoutId: Int = 0) : Fragment(contentLayoutId){

    protected lateinit var fragmentView: View

    protected lateinit var resultTextView: TextView
    protected lateinit var solveButton: Button
    protected lateinit var nextButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentView = view
        resultTextView = fragmentView.findViewById(R.id.result)
        solveButton = fragmentView.findViewById(R.id.solve)
        nextButton = fragmentView.findViewById(R.id.next)

        solveButton.setOnClickListener { onSolve() }
        nextButton.setOnClickListener { onNext() }
    }

    protected abstract fun onSolve()

    protected abstract fun onNext()

    protected abstract fun updateUiToSolved()

    protected abstract fun updateUiToNext()
}