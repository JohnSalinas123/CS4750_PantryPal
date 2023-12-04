package com.example.pantry_pal.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.pantry_pal.ui.grocery_list.GroceryList
import java.util.UUID

@Dao
interface GroceryListDao {
    @Query("SELECT * FROM GroceryList")
    suspend fun getItem(): List<GroceryList>

    @Query("SELECT * FROM GroceryList WHERE id=(:id)")
    suspend fun getItem(id: UUID): GroceryList

    @Update
    suspend fun updateItem(GroceryList: GroceryList)

    @Insert
    suspend fun addItem(GroceryList: GroceryList)
}