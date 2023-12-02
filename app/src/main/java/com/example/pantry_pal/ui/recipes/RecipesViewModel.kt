package com.example.pantry_pal.ui.recipes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pantry_pal.data.IngredientForRecipe
import com.example.pantry_pal.data.Recipe
import com.example.pantry_pal.data.Step
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecipesViewModel : ViewModel() {

    private val _recipes = MutableLiveData<List<Recipe>>()

    val recipes: LiveData<List<Recipe>> get() = _recipes

    // TODO: remove mock data later
    init {
        Log.d("RecipesViewModel", "ViewModel initialized")
    }

    fun getRecipes() {
        Log.d("RecipesViewModel", "getRecipes called")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // TODO: fetch recipes from api
                val fetchedRecipes = createMockRecipes()
                withContext(Dispatchers.Main) {
                    _recipes.value = fetchedRecipes
                }




            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _recipes.postValue(emptyList())
                }


            }
        }

    }

    private fun createMockRecipes(): List<Recipe> {
        return listOf(
            Recipe(1, "Burger", "This is a burger recipe", false, createMockIngredients(), createMockSteps()),
            Recipe(2, "Pasta", "Delicious pasta recipe", true, createMockIngredients(), createMockSteps()),
            // Add more mock recipes as needed
        )
    }

    private fun createMockIngredients(): List<IngredientForRecipe> {
        return listOf(
            IngredientForRecipe(1, "Beef Patty", "protein"),
            IngredientForRecipe(2, "Cheddar Cheese", "dairy"),
            IngredientForRecipe(3, "Lettuce", "vegetable")
            // Add more mock ingredients as needed
        )
    }

    private fun createMockSteps(): List<Step> {
        return listOf(
            Step(1, "Pan fry beef patty on stove until cooked to liking"),
            Step(2, "Add cheddar cheese slice on cooking beef patty, remove patty when cheese is melted")
            // Add more mock steps as needed
        )
    }




}