package com.example.notetakingapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class ViewModal(): ViewModel(),CoroutineScope
{

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + SupervisorJob()

}