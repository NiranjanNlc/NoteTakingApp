package com.example.notetakingapp.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notetakingapp.model.data.Fidility

@Entity(tableName = "notes_table")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var fidility: Fidility,
    var description: String,
    var dateCreated: String
)
