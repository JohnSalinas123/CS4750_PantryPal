package com.example.pantry_pal.ui.grocery_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GroceryListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is grocery list Fragment"
    }
    val text: LiveData<String> = _text
}