package com.example.notetakingapp.model.repo

import androidx.lifecycle.LiveData
import com.example.notetakingapp.model.dao.NotesDao
import com.example.notetakingapp.model.data.Notes

class NotesRepo(private val notesDao: NotesDao) {

    val getAllData = notesDao.getAllData()
    val sortByHighPriority = notesDao.sortByHighPriority()
    val sortByLowPriority = notesDao.sortByLowPriority()

    suspend fun insertData(notes: Notes) {
        notesDao.insertData(notes)
    }

    suspend fun updateData(notes: Notes)
    {
        println(" In update sections  ${notes.toString()}")
        notesDao.updateData(notes)
    }

    suspend fun deleteData(notes: Notes) {
        notesDao.deleteData(notes)
    }

    suspend fun deleteAllData() {
        notesDao.deleteAllData()
    }

    fun searchData(query: String): LiveData<List<Notes>> {
        return notesDao.searchData(query)
    }
}
    