package ru.rxnnct.yesorno.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface SettingsDao {

    @Query("SELECT * FROM settings_table WHERE id = 1")
    fun getSettings(): Flow<Settings>

    @Insert
    fun insert(settings: Settings)

    @Update
    fun update(settings: Settings)

    @Query("DELETE FROM settings_table")
    suspend fun deleteAll()

//    @Query("SELECT tutorial_completed FROM config_table WHERE id = 1")
//    fun isTutorialCompleted(): Boolean
}