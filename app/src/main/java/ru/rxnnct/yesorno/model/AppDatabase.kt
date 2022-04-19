package ru.rxnnct.yesorno.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

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

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database_yes_or_no"
                ).allowMainThreadQueries() // TODO: delete
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}