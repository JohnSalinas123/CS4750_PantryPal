package com.example.pantry_pal.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pantry_pal.ui.grocery_list.Grocery
import kotlinx.coroutines.flow.Flow

@Dao
interface GroceryDao {
    @Query("SELECT * FROM grocery ORDER BY id ASC")
    fun getGrocery(): Flow<List<Grocery>>

    @Query("SELECT * FROM grocery WHERE item = (:item)")
     fun getItem(item:String):Grocery
    @Delete
     suspend fun deleteItem(grocery: Grocery)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun addItem(grocery: Grocery)
}