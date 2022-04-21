package ru.rxnnct.yesorno.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SolutionResultDao {
    @Query("SELECT * FROM solution_result_table ORDER BY id ASC")
    fun getSolutionResults(): Flow<List<SolutionResult>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: SolutionResult)

    // TODO: delete oldest:
//    @Query("DELETE FROM solution_result_table")
//    suspend fun deleteAll()
}