package ru.rxnnct.yesorno

import android.app.Application
import ru.rxnnct.yesorno.model.AppDatabase
import ru.rxnnct.yesorno.model.SettingsRepository
import ru.rxnnct.yesorno.model.SolutionResultRepository

class YesOrNoApplication : Application() {
    val database by lazy { AppDatabase.getInstance(this) }
    val solutionResultRepository by lazy { SolutionResultRepository(database.solutionResultDao()) }
    val settingsRepository by lazy { SettingsRepository(database.settingsDao()) }
}