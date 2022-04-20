package ru.rxnnct.yesorno.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// TODO: migrations 
@Database(
    entities = [Settings::class, SolutionResult::class],
    version = 1,
    exportSchema = false
)
public abstract class AppDatabase : RoomDatabase() {
    abstract fun settingsDao(): SettingsDao
    abstract fun solutionResultDao(): SolutionResultDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(
            context: Context,
            scope: CoroutineScope
        ): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database_yes_or_no"
                )
                    .allowMainThreadQueries() // TODO: delete
                    .addCallback(AppDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class AppDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.solutionResultDao())
                }
            }
        }

        suspend fun populateDatabase(solutionResultDao: SolutionResultDao) {
            var solutionResult = SolutionResult(1, "testType1", "testQ", "testRes")
            solutionResultDao.insert(solutionResult)
            solutionResult = SolutionResult(2, "testType2", "testQ", "testRes")
            solutionResultDao.insert(solutionResult)
            solutionResult = SolutionResult(3, "testType3", "testQ", "testRes")
            solutionResultDao.insert(solutionResult)
            solutionResult = SolutionResult(4, "testType4", "testQ", "testRes")
            solutionResultDao.insert(solutionResult)
            solutionResult = SolutionResult(5, "testType5", "testQ", "testRes")
            solutionResultDao.insert(solutionResult)
            solutionResult = SolutionResult(6, "testType6", "testQ", "testRes")
            solutionResultDao.insert(solutionResult)
            solutionResult = SolutionResult(7, "testType7", "testQ", "testRes")
            solutionResultDao.insert(solutionResult)
        }
    }
}