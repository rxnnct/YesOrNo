package ru.rxnnct.yesorno.screens.solutions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.rxnnct.yesorno.model.SolutionResult
import ru.rxnnct.yesorno.model.SolutionResultRepository
import ru.rxnnct.yesorno.model.SolutionType
import kotlin.random.Random

class CoinSolutionViewModel(repository: SolutionResultRepository) :
    BaseSolutionViewModel(repository) {


    var headQuestion = ""
    var tailQuestion = ""

    override fun solve() {
        result = if (Random.nextBoolean()) {
            headQuestion
        } else {
            tailQuestion
        }
        val solutionResult = SolutionResult(SolutionType.YES_OR_NO.solutionName,
            "$headQuestion or $tailQuestion", result)
        insert(solutionResult)
    }

    override fun next() {
        headQuestion = ""
        tailQuestion = ""
        result = ""
    }
}

// TODO: extract to base
class CoinSolutionViewModelFactory(private val repository: SolutionResultRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CoinSolutionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CoinSolutionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}