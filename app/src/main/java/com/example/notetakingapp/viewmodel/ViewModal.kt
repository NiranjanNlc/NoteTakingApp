package com.example.notetakingapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notetakingapp.model.data.Notes
import com.example.notetakingapp.model.repo.NotesRepo
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class ViewModal(private val repo: NotesRepo): ViewModel(),CoroutineScope
{
    fun addData(notes: Notes?) {
        this.launch{
            if (notes != null) {
                repo.updateData(notes)
            }
        }
    }

    val notes = repo.getAllData
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + SupervisorJob()

    init {
        println(" oourr notes ${notes.value}")
    }
}