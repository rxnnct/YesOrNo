package ru.rxnnct.yesorno.screens.solutions

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class YesNoSolutionViewModel : ViewModel() {

    var currentQuestion = ""
    var isDone = false

    private fun solve() {
        var result = "$currentQuestion ${Random.nextBoolean()}"
        isDone = true
    }

    fun onSolve() {
        solve()
    }

    fun onNext() {

    }

}