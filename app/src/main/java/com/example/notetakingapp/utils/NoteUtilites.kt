package com.example.notetakingapp.utils

import com.example.notetakingapp.model.data.Fidility
import com.example.notetakingapp.model.data.Notes

object NoteUtilites
{

    fun initiateDtaBase()
    {
          val notes = Notes ( title = "some thing",
              fidility = Fidility.IMPORTANT,
          description = "some thing",
         dateCreated="some thing"
                  )
    }
}