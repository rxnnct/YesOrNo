package ru.rxnnct.yesorno.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ConfigDao {
    @Query("SELECT tutorial_completed from config where id = 1")
    fun isTutorialCompleted(): Boolean
}