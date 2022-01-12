package com.example.notetakingapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.notetakingapp.model.repo.NotesRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class ViewModal(private val repo: NotesRepo): ViewModel(),CoroutineScope
{

    val notes = repo.getAllData
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + SupervisorJob()

    init {
        println(" oourr notes ${notes.value}")
    }
}