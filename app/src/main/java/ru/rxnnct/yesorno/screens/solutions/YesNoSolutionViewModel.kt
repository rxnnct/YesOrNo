package ru.rxnnct.yesorno.screens.solutions

import androidx.lifecycle.*
import ru.rxnnct.yesorno.model.SolutionResult
import ru.rxnnct.yesorno.model.SolutionResultRepository
import ru.rxnnct.yesorno.model.SolutionType
import kotlin.random.Random

class YesNoSolutionViewModel(repository: SolutionResultRepository) : BaseSolutionViewModel(repository) {

    override fun solve() {
        result = "${Random.nextBoolean()}"
        val solutionResult = SolutionResult(SolutionType.YES_OR_NO.solutionName, question, result)
        insert(solutionResult)
    }

    override fun next() {
        question = ""
        result = ""
    }
}

class YesNoSolutionViewModelFactory(private val repository: SolutionResultRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(YesNoSolutionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return YesNoSolutionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}