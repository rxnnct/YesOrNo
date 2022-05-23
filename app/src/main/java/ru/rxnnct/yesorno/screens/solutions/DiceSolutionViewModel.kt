package ru.rxnnct.yesorno.screens.solutions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.rxnnct.yesorno.model.SolutionResultRepository

class DiceSolutionViewModel(repository: SolutionResultRepository) :
    BaseSolutionViewModel(repository) {

    override fun solve() {
        TODO("Not yet implemented")
    }

    override fun next() {
        TODO("Not yet implemented")
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