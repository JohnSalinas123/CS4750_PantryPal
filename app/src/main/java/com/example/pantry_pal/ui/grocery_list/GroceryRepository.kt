package com.example.pantry_pal.ui.grocery_list

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.room.Room
import com.example.pantry_pal.data.GroceryDao
import com.example.pantry_pal.data.GroceryDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.util.UUID
private const val DATABASE_NAME = "grocery-database"
//class GroceryRepository(private val groceryDao: GroceryDao) {
//    val allGroceryItems: Flow<List<Grocery>> = groceryDao.getGrocery()
//
//    @WorkerThread
//    suspend fun insertGroceryItem(grocery: Grocery) {
//        groceryDao.addItem(grocery)
//    }
//
//    @WorkerThread
//    suspend fun deleteGroceryItem(grocery: Grocery) {
//        groceryDao.deleteItem(grocery)
//    }





class GroceryRepository private constructor(
    context: Context,
    private val coroutineScope: CoroutineScope = GlobalScope
) {

    private val database: GroceryDatabase = Room.databaseBuilder(
        context.applicationContext,
        GroceryDatabase::class.java,
        DATABASE_NAME
    ).build()

    fun getGrocery(): Flow<List<Grocery>> = database.groceryDao().getGrocery()

     fun getItem(id: Int): Grocery = database.groceryDao().getItem(id)
     fun addGrocery(item: String) {
         coroutineScope.launch {
             val newItem = Grocery(item = item)
             database.groceryDao().addItem(newItem)
         }
    }

     fun deleteGrocery(item: String) {
         coroutineScope.launch {
             val newItem = Grocery(item = item)
             database.groceryDao().deleteItem(newItem)
         }
    }

    companion object {
        private var INSTANCE: GroceryRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = GroceryRepository(context)
            }
        }
        fun get(): GroceryRepository {
            return INSTANCE ?: throw IllegalStateException("GroceryRepository must be initialized")
        }
    }
}