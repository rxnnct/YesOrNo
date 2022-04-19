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

    @Query("SELECT EXISTS(SELECT 1 FROM settings_table WHERE id = 1)")
    fun isSettingsExists(): Boolean

//    @Query("SELECT tutorial_completed FROM config_table WHERE id = 1")
//    fun isTutorialCompleted(): Boolean
}