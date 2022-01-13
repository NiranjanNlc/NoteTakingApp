package com.example.notetakingapp.model.repo

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.notetakingapp.model.dao.NotesDao
import com.example.notetakingapp.model.data.Notes
import java.lang.Exception

class NotesRepo(private val notesDao: NotesDao) {

    val getAllData = notesDao.getAllData()
    val sortByHighPriority = notesDao.sortByHighPriority()
    val sortByLowPriority = notesDao.sortByLowPriority()

    suspend fun insertData(notes: Notes) {
        try {
            notesDao.insertData(notes)
        }
        catch (e:Exception)
        {
            Log.i("Error ", e.message.toString())
        }
    }

    suspend fun updateData(notes: Notes)
    {
        println(" In update sections  ${notes.toString()}")
        try {
            notesDao.updateData(notes)
        }
        catch (e:Exception)
        {
            Log.i("Error ", e.message.toString())
        }

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
    