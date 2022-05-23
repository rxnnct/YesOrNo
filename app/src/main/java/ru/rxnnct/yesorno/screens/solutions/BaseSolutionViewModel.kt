package ru.rxnnct.yesorno.screens.solutions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.rxnnct.yesorno.model.SolutionResult
import ru.rxnnct.yesorno.model.SolutionResultRepository

abstract class BaseSolutionViewModel(private val repository: SolutionResultRepository) : ViewModel() {

    var question = ""
    var result = ""

    abstract fun solve()

    abstract fun next()

    protected fun insert(solutionResult: SolutionResult) = viewModelScope.launch {
        repository.insert(solutionResult)
    }
}