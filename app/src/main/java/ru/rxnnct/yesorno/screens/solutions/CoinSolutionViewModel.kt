package ru.rxnnct.yesorno.screens.solutions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.rxnnct.yesorno.model.SolutionResultRepository

class CoinSolutionViewModel(repository: SolutionResultRepository) :
    BaseSolutionViewModel(repository) {

    override fun solve() {
        TODO("Not yet implemented")
    }

    override fun next() {
        TODO("Not yet implemented")
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