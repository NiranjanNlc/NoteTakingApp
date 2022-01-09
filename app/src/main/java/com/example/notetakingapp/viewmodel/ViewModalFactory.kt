package com.example.notetakingapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notetakingapp.model.repo.NotesRepo

class ViewModalFactory(private val repository: NotesRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        println(" Inn view odal factory")
        if (modelClass.isAssignableFrom(ViewModal::class.java)) {
            println("Assighnabke class")
            @Suppress("UNCHECKED_CAST")
            return ViewModal() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}