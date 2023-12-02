package com.example.pantry_pal.data

data class Recipe (

    val id: Int,
    val name: String,
    val description: String,
    val vegetarian : Boolean,
    val ingredients: List<IngredientForRecipe>,
    val steps: List<Step>

)

data class IngredientForRecipe(
    val ingredientsId: Int,
    val name: String,
    val category: String,

)

data class Step(
    val stepNum: Int,
    val instruction: String
)