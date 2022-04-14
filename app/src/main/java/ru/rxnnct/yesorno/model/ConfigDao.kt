package ru.rxnnct.yesorno.model

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ConfigDao {

    @Query("SELECT EXISTS(SELECT 1 FROM config WHERE id = 1)")
    fun isConfigExists(): Boolean

    @Query("SELECT tutorial_completed FROM config WHERE id = 1")
    fun isTutorialCompleted(): Boolean
}