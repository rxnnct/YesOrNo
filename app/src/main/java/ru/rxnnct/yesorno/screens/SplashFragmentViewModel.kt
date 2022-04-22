package ru.rxnnct.yesorno.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import ru.rxnnct.yesorno.model.Settings
import ru.rxnnct.yesorno.model.SettingsRepository

class SplashFragmentViewModel(private val repository: SettingsRepository) : ViewModel() {
    val settings: LiveData<Settings> = repository.settings.asLiveData()


}