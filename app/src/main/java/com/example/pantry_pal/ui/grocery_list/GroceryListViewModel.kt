package com.example.pantry_pal.ui.grocery_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class GroceryListViewModel : ViewModel() {

    private val _groceryItems = MutableLiveData<MutableList<String>>(mutableListOf())
    val groceryItems: LiveData<MutableList<String>> = _groceryItems

    // Function to add an item
    fun addItem(item: String) {
        val updatedList = groceryItems.value ?: mutableListOf()
        updatedList.add(item)
        _groceryItems.value = updatedList
    }

    // Function to remove an item
    fun removeItem(item: String) {
        val updatedList = groceryItems.value ?: mutableListOf()
        updatedList.remove(item)
        _groceryItems.value = updatedList
    }
}