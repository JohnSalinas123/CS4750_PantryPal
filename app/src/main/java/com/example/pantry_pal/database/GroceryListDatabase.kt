package com.example.pantry_pal.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pantry_pal.ui.grocery_list.GroceryList

@Database(entities = [ GroceryList::class ], version=3)
@TypeConverters(GroceryListTypeConverter::class)
abstract class GroceryListDatabase : RoomDatabase() {
    abstract fun GroceryListDao(): GroceryListDao
}

val migration_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE GroceryList ADD COLUMN suspect TEXT NOT NULL DEFAULT ''"
        )
    }
}

val migration_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE GroceryList ADD COLUMN photoFileName TEXT"
        )
    }
}