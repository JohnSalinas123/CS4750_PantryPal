package com.example.pantry_pal.ui.bmi_calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiCalculatorViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is meal plan Fragment"
    }
    val text: LiveData<String> = _text

}