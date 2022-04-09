package ru.rxnnct.yesorno.screens.solutions

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class YesNoSolutionViewModel : ViewModel() {

    var question = ""
    var result = ""

    private fun solve(){
        result = "$question ${Random.nextBoolean()}"
        // TODO: save to room
    }

    private fun next(){
        question = ""
        result = ""
    }

    fun onSolve() {
        solve()
    }

    fun onNext() {
        next()
    }

}