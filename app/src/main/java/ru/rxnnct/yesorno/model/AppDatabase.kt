package ru.rxnnct.yesorno.model

import androidx.room.Database
import androidx.room.RoomDatabase

// TODO: migrations 
@Database(
    entities = [Config::class, SolutionResult::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun configDao(): ConfigDao
    abstract fun solutionResultDao(): SolutionResultDao
}