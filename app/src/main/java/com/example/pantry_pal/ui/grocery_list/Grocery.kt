package com.example.pantry_pal.ui.grocery_list

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grocery")
data class Grocery(
    @PrimaryKey(autoGenerate = true) val id: Int =0,
    val item: String
)
