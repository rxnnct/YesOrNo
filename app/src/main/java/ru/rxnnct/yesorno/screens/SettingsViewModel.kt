package ru.rxnnct.yesorno.screens

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.rxnnct.yesorno.model.Settings
import ru.rxnnct.yesorno.model.SettingsRepository

class SettingsViewModel(private val repository: SettingsRepository) : ViewModel() {
    val settings: LiveData<Settings> = repository.settings.asLiveData()

    fun update(settings: Settings) = viewModelScope.launch {
        repository.update(settings)
    }
}

class SettingsViewModelFactory(private val repository: SettingsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SettingsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}