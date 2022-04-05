package ru.rxnnct.yesorno.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * For history
 */

@Entity(tableName = "solution_results")
data class SolutionResult (
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "solution_type")
    val solutionType: String
)