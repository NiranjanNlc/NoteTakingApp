package com.example.notetakingapp.model.db

import androidx.room.TypeConverter
import com.example.notetakingapp.model.data.Fidility

class Converter
{
    @TypeConverter
    fun fromFidility (fidility : Fidility): String = fidility .name

    @TypeConverter
    fun toFidility (fidility : String): Fidility  = Fidility .valueOf(fidility )
}