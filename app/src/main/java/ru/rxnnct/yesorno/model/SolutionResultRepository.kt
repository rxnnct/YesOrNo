package ru.rxnnct.yesorno.model

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class SolutionResultRepository(private val solutionResultDao: SolutionResultDao) {

    val allSolutionResults: Flow<List<SolutionResult>> = solutionResultDao.getSolutionResults()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(solutionResult: SolutionResult) {
        solutionResultDao.insert(solutionResult)
    }
}