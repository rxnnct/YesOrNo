package ru.rxnnct.yesorno.screens

import androidx.lifecycle.*
import ru.rxnnct.yesorno.model.SolutionResult
import ru.rxnnct.yesorno.model.SolutionResultRepository

class HistoryViewModel(private val repository: SolutionResultRepository) : ViewModel() {

    val allSolutionResults: LiveData<List<SolutionResult>> =
        repository.allSolutionResults.asLiveData()
}

class HistoryViewModelFactory(private val repository: SolutionResultRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HistoryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}