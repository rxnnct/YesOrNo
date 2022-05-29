package ru.rxnnct.yesorno.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.rxnnct.yesorno.R

class SolutionsFragment: Fragment(R.layout.fragment_solutions) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.yesNoButton).setOnClickListener{
            findNavController().navigate(R.id.action_mainMenuFragment_to_yesNoSolutionFragment)
        }

        view.findViewById<Button>(R.id.coinButton).setOnClickListener{
            findNavController().navigate(R.id.action_solutionFragment_to_coinSolutionFragment)
        }

        view.findViewById<Button>(R.id.diceButton).setOnClickListener{
            findNavController().navigate(R.id.action_solutionFragment_to_diceSolutionFragment)
        }
    }
}