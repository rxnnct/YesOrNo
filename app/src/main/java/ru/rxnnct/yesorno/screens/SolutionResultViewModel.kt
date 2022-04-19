package ru.rxnnct.yesorno.screens

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.rxnnct.yesorno.model.SolutionResult
import ru.rxnnct.yesorno.model.SolutionResultRepository

class SolutionResultViewModel(private val repository: SolutionResultRepository) : ViewModel() {

    val allSolutionResults: LiveData<List<SolutionResult>> = repository.allSolutionResults.asLiveData()

    fun insert(solutionResult: SolutionResult) = viewModelScope.launch {
        repository.insert(solutionResult)
    }
}

class SolutionResultViewModelFactory(private val repository: SolutionResultRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SolutionResultViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SolutionResultViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}