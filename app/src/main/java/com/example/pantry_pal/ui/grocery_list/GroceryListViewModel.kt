package com.example.pantry_pal.ui.grocery_list



import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


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

}