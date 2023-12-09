package com.example.pantry_pal.ui.grocery_list

//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData

import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

//class GroceryListViewModel(private val repository: GroceryRepository) : ViewModel() {
//    val grocery: LiveData<List<Grocery>> = repository.allGroceryItems.asLiveData()
//
//    fun addGroceryItem(grocery: Grocery) = viewModelScope.launch {
//        repository.insertGroceryItem(grocery)
//    }
//
//    fun deleteGroceryItem(grocery: Grocery) = viewModelScope.launch {
//        repository.deleteGroceryItem(grocery)
//    }
//}
//
//class GroceryModelFactory(private val repository: GroceryRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(GroceryListViewModel::class.java))
//            return GroceryListViewModel(repository) as T
//
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//
//


class GroceryListViewModel: ViewModel() {
    private val groceryRepository = GroceryRepository.get()
    private val _grocery: MutableStateFlow<List<Grocery>> = MutableStateFlow(emptyList())

    val grocery: StateFlow<List<Grocery>>
        get() = _grocery.asStateFlow()

    init {
        viewModelScope.launch {
            groceryRepository.getGrocery().collect {
                _grocery.value = it
            }
        }
    }

     fun addItem(item: String) {
        groceryRepository.addGrocery(item)
    }
     fun deleteItem(item:String) {
        groceryRepository.deleteGrocery(item)
    }














//    private val _groceryItems = MutableLiveData<MutableList<String>>(mutableListOf())
//    val groceryItems: LiveData<MutableList<String>> = _groceryItems
//
//    // Function to add an item
//    fun addItem(item: String) {
//        val updatedList = groceryItems.value ?: mutableListOf()
//        updatedList.add(item)
//        _groceryItems.value = updatedList
//    }
//
//    // Function to remove an item
//    fun removeItem(item: String) {
//        val updatedList = groceryItems.value ?: mutableListOf()
//        updatedList.remove(item)
//        _groceryItems.value = updatedList
//    }
//    private val groceryRepository = GroceryRepository.get()
//
//    private val _grocery: MutableStateFlow<List<Grocery>> = MutableStateFlow(emptyList())
//    val grocery: StateFlow<List<Grocery>>
//        get() = _grocery.asStateFlow()
//
//    init {
//        viewModelScope.launch {
//            groceryRepository.getGrocery().collect {
//                _grocery.value = it
//            }
//        }
//        Log.d("Repository", "Repository initialize")
//    }
//
//     fun addItem(grocery: Grocery) {
//        groceryRepository.addGrocery(grocery)
//    }
//
//     fun deleteItem(grocery: Grocery) {
//        groceryRepository.deleteGrocery(grocery)
//    }

}