package ru.rxnnct.yesorno.screens.solutions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.rxnnct.yesorno.model.SolutionResult
import ru.rxnnct.yesorno.model.SolutionResultRepository
import ru.rxnnct.yesorno.model.SolutionType
import kotlin.random.Random

class DiceSolutionViewModel(repository: SolutionResultRepository) :
    BaseSolutionViewModel(repository) {

    override fun solve() {
        result = "${(1..6).random()}"
        val solutionResult = SolutionResult(SolutionType.DICE.solutionName, question, result)
        insert(solutionResult)
    }

    override fun next() {
        question = ""
        result = ""
    }
}

// TODO: extract to base
class DiceSolutionViewModelFactory(private val repository: SolutionResultRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiceSolutionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DiceSolutionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}