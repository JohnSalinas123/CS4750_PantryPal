package com.example.pantry_pal.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.pantry_pal.ui.grocery_list.Grocery


@Database(entities = [Grocery::class], version = 1, exportSchema = false)
abstract class GroceryDatabase : RoomDatabase() {
    abstract fun groceryDao(): GroceryDao
}