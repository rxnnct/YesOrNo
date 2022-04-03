package ru.rxnnct.yesorno.screens.solutions

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.rxnnct.yesorno.R

class YesNoSolutionFragment: Fragment(R.layout.fragment_yes_no_solution) {

    private lateinit var viewModel: YesNoSolutionViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(YesNoSolutionViewModel::class.java)
    }
}