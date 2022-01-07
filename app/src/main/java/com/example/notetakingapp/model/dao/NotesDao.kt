package com.example.notetakingapp.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notetakingapp.model.data.Notes

@Dao
interface NotesDao
{
    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun getAllData(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(notes: Notes)

    @Update
    suspend fun updateData(notes: Notes)

    @Delete
    suspend fun deleteData(notes: Notes)

    @Query("DELETE FROM notes_table")
    suspend fun deleteAllData()

    @Query("SELECT * FROM notes_table WHERE title LIKE :query")
    fun searchData(query: String): LiveData<List<Notes>>

    @Query("SELECT * FROM notes_table ORDER BY CASE WHEN fidility LIKE 'H$' THEN 1 WHEN fidility LIKE 'M%' THEN 2 WHEN fidility LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): LiveData<List<Notes>>

    @Query("SELECT * FROM notes_table ORDER BY CASE WHEN fidility LIKE 'L$' THEN 1 WHEN fidility LIKE 'M%' THEN 2 WHEN fidility LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): LiveData<List<Notes>>

}