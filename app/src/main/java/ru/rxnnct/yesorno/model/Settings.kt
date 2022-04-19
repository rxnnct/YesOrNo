package ru.rxnnct.yesorno.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "settings_table")
data class Settings(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "tutorial_completed", defaultValue = "false")
    val tutorialCompleted: Boolean
)