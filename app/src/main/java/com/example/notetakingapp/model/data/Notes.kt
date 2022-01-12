package com.example.notetakingapp.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notetakingapp.model.data.Fidility
import java.io.Serializable

@Entity(tableName = "notes_table")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var fidility: Fidility,
    var description: String,
    var dateCreated: String
) : Serializable {
    constructor(
        title: String,
        fidility: Fidility,
        description: String,
        dateCreated: String
    ) : this(1,
        title,
        fidility,
        description,
        dateCreated
    )
}
