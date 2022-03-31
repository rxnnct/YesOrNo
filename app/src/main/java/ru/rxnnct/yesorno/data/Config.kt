package ru.rxnnct.yesorno.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "config")
data class Config(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "tutorial_completed", defaultValue = "false") val tutorialCompleted: Boolean
)