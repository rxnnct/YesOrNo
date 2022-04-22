package ru.rxnnct.yesorno

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import ru.rxnnct.yesorno.model.AppDatabase
import ru.rxnnct.yesorno.model.SettingsRepository
import ru.rxnnct.yesorno.model.SolutionResultRepository

class YesOrNoApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { AppDatabase.getInstance(this, applicationScope) }
    val solutionResultRepository by lazy { SolutionResultRepository(database.solutionResultDao()) }
    val settingsRepository by lazy { SettingsRepository(database.settingsDao()) }
}