package com.example.pantry_pal.database

import androidx.room.TypeConverter
import java.util.Date

class GroceryListTypeConverter {
    @TypeConverter
    fun fromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun toDate(millisSinceEpoch: Long): Date {
        return Date(millisSinceEpoch)
    }
}