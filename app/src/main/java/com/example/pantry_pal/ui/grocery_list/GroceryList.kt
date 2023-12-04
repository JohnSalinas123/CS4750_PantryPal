package com.example.pantry_pal.ui.grocery_list

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity
data class GroceryList(
    @PrimaryKey val id: UUID,
    val Grocery: String,
    val date: Date,
    val item: String = "",
)