package ru.rxnnct.yesorno.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Config::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun configDao(): ConfigDao
}