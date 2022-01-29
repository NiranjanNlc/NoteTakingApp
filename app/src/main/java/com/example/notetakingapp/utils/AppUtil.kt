package com.example.notetakingapp.utils

import android.content.Context
import com.example.notetakingapp.model.db.NotesDb
import com.example.notetakingapp.model.repo.NotesRepo
import com.example.notetakingapp.viewmodel.ViewModal
import com.example.notetakingapp.viewmodel.ViewModalFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

object AppUtil {
    fun getViewModel(context: Context): ViewModal {
        val applicationScope = CoroutineScope(SupervisorJob())
        val database =  NotesDb.getDatabase(context,applicationScope)
        val repo = NotesRepo(database.notesdDao())
        return ViewModalFactory(repo).create(ViewModal::class.java)
    }


}