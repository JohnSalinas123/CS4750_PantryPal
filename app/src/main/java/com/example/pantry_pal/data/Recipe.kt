package com.example.pantry_pal.data

data class Recipe (

    val id: Int,
    val name: String,
    val calories: Int,
    val description: String,
    val diet : String,
    val ingredients: List<IngredientForRecipe>,
    val steps: List<Step>

)

data class IngredientForRecipe(
    val ingredientsId: Int,
    val name: String,
    val quantity: String,
    val category: String,

)

data class Step(
    val stepNum: Int,
    val instruction: String
)