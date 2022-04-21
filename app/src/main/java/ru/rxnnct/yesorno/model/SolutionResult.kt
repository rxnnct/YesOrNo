package ru.rxnnct.yesorno.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * For history
 */

@Entity(tableName = "solution_result_table")
data class SolutionResult (
    @ColumnInfo(name = "solution_type")
    var solutionType: String,
    @ColumnInfo(name = "question")
    var question: String,
    @ColumnInfo(name = "result")
    var result: String

    // TODO:  datetime col

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}