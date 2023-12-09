package com.example.pantry_pal.ui.grocery_list

import android.app.Application

class GroceryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        GroceryRepository.initialize(this)
    }
}