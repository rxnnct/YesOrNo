package ru.rxnnct.yesorno.model

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class SettingsRepository(private val settingsDao: SettingsDao) {

    val settings: Flow<Settings> = settingsDao.getSettings()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(settings: Settings) {
        settingsDao.update(settings)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(settings: Settings) {
        settingsDao.insert(settings)
    }
}