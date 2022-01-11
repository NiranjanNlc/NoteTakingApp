package com.example.notetakingapp.utils

import com.example.notetakingapp.model.data.Fidility
import com.example.notetakingapp.model.data.Notes

object NoteUtilites
{

    fun initiateDtaBase()
    {
        var descriptionList = listOf<String>(" Niranjan lamichhane ",
        " ashmita thapa       ",
        " sashmita neupane    ",
        " rachana poudel ",
        " jharana bajracharya  ",
        " Ashma Baniya ",
        " ")
        descriptionList.forEach {
            insertData(it)
        }
    }

    private fun insertData(sesc: String)
    {


    }
}