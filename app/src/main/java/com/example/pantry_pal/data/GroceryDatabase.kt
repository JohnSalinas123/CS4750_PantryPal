package com.example.pantry_pal.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.pantry_pal.ui.grocery_list.Grocery


@Database(entities = [Grocery::class], version = 1, exportSchema = false)
abstract class GroceryDatabase : RoomDatabase() {
    abstract fun groceryDao(): GroceryDao

//    companion object {
//        @Volatile
//        private var INSTANCE:GroceryDatabase? = null
//
//        fun getDatabase(context: Context): GroceryDatabase {
//            return INSTANCE?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    GroceryDatabase::class.java,
//                    "grocery-database"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
}