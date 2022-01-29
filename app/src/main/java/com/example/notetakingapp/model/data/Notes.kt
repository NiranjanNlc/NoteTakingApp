package com.example.notetakingapp.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notetakingapp.model.data.Fidility
import java.io.Serializable

@Entity(tableName = "notes_table")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int?=null,
    var title: String?=null,
    var fidility: Fidility?=null,
    var description: String?=null,
    var dateCreated: String?=null
) : Serializable {
//    constructor(
//        title: String?=null,
//        fidility: Fidility,
//        description: String?=null,
//        dateCreated: String?=null
//    ) : this(1,
//        title,
//        fidility,
//        description,
//        dateCreated
//    )
}
