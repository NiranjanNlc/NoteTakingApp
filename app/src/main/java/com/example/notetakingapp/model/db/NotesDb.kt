package com.example.notetakingapp.model.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.notetakingapp.model.dao.NotesDao
import com.example.notetakingapp.model.data.Fidility
import com.example.notetakingapp.model.data.Notes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class NotesDb : RoomDatabase() {
    abstract fun notesdDao(): NotesDao
    private class NotesDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var notesDao = database.notesdDao()
                        initiseDb(notesDao)
                }
            }
        }

        private suspend fun initiseDb(notesDao: NotesDao) {
            var descriptionList = listOf<String>(" Niranjan lamichhane ",
                " ashmita thapa       ",
                " sashmita neupane    ",
                " rachana poudel ",
                " jharana bajracharya  ",
                " Ashma Baniya ",
                " ")
            descriptionList.forEach {
                insertData(it,notesDao)
            }
        }

        private suspend fun insertData(sesc: String, notesDao: NotesDao)
        {
            val notes = Notes ( title = "some thing",
                fidility = Fidility.IMPORTANT,
                sesc,
                dateCreated="some thing"
            )
            notesDao.insertData(notes)
        }
    }
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE:NotesDb? = null

        fun getDatabase(context: Context, scope: CoroutineScope):NotesDb {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database]
            println("You have acces over here ")
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                   NotesDb::class.java,
                    "girl_database"
                ).addCallback(NotesDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }


    }
}