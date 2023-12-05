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
            Recipe(1, "Cheeseburger w/ Fries and Soda",500, "Indulge in the classic American comfort meal with our mouthwatering Cheeseburger recipe paired perfectly with golden, crispy Fries and a refreshing Soda. Succulent beef patty topped with melted cheese, crisp lettuce, juicy tomatoes, and zesty pickles, all nestled within a soft, toasted bun. Served alongside a generous portion of seasoned fries for that perfect crunch, and a chilled soda to complement the flavors. Elevate your dining experience with this timeless trio of Cheeseburger, Fries, and Soda – a delightful symphony of taste, texture, and satisfaction!", "Balanced", createMockIngredients(), createMockSteps()),
            Recipe(2, "Spaghetti and Meatballs",800, "Embark on a culinary journey with our delectable Spaghetti and Meatballs recipe. This classic Italian dish features perfectly cooked al dente spaghetti, generously smothered in a rich, savory tomato sauce. Nestled atop this pasta perfection are succulent, homemade meatballs, a harmonious blend of seasoned ground meat. Garnished with a sprinkle of Parmesan cheese and fresh basil, this dish promises a symphony of flavors and textures in every forkful. Whether you're a fan of Italian cuisine or seeking a comforting and satisfying meal, our Spaghetti and Meatballs recipe is a timeless choice that will tantalize your taste buds.", "Balanced", createMockIngredients(), createMockSteps()),
            Recipe(3, "Savory Chicken Alfredo", 420, "Indulge in a creamy symphony of flavors with our Savory Chicken Alfredo. Tender chicken, al dente fettuccine, and a rich Alfredo sauce.", "Balanced", createMockIngredients(), createMockSteps()),
            Recipe(4, "Mango Quinoa Salad", 300, "Experience a burst of freshness with our Mango Quinoa Salad. Quinoa, ripe mango chunks, and a tangy citrus dressing.", "Vegetarian", createMockIngredients(), createMockSteps()),
            Recipe(5, "Spicy Black Bean Tacos", 350, "Add a kick to your day with our Spicy Black Bean Tacos. Flavorful black beans, crisp lettuce, and a spicy salsa.", "Vegan", createMockIngredients(), createMockSteps()),
            Recipe(6, "Garlic Parmesan Shrimp", 380, "Elevate your seafood experience with Garlic Parmesan Shrimp. Succulent shrimp coated in a garlic parmesan crust.", "Pescatarian", createMockIngredients(), createMockSteps()),
            Recipe(7, "Mediterranean Chickpea Bowl", 320, "Escape to the Mediterranean with our Chickpea Bowl. Chickpeas, olives, and feta cheese in a lemon herb dressing.", "Mediterranean", createMockIngredients(), createMockSteps()),
            Recipe(8, "Teriyaki Tofu Stir-Fry", 280, "Savor the umami goodness of Teriyaki Tofu Stir-Fry. Crispy tofu, colorful vegetables, and a sweet teriyaki glaze.", "Vegetarian", createMockIngredients(), createMockSteps()),
            Recipe(9, "Cajun Grilled Salmon", 400, "Enjoy a taste of the bayou with our Cajun Grilled Salmon. Spicy Cajun seasoning on a perfectly grilled salmon fillet.", "Pescatarian", createMockIngredients(), createMockSteps()),
            Recipe(10, "Caprese Pesto Panini", 350, "Delight in the simplicity of our Caprese Pesto Panini. Fresh tomatoes, mozzarella, basil, and a dollop of pesto.", "Vegetarian", createMockIngredients(), createMockSteps()),
            Recipe(11, "Thai Basil Beef Noodles", 430, "Experience the bold flavors of Thai cuisine with our Basil Beef Noodles. Stir-fried beef, rice noodles, and aromatic basil.", "Balanced", createMockIngredients(), createMockSteps()),
            Recipe(12, "Sweet Potato & Black Bean Chili", 320, "Warm your soul with Sweet Potato & Black Bean Chili. Hearty black beans, sweet potatoes, and a blend of spices.", "Vegetarian", createMockIngredients(), createMockSteps()),
            Recipe(13, "Lemon Herb Grilled Chicken", 380, "Tantalize your taste buds with Lemon Herb Grilled Chicken. Juicy chicken marinated in zesty lemon and herbs.", "Balanced", createMockIngredients(), createMockSteps()),
            Recipe(14, "Spinach and Feta Stuffed Mushrooms", 250, "Delight in a bite-sized treat with Spinach and Feta Stuffed Mushrooms. Mushrooms filled with a savory spinach and feta mixture.", "Vegetarian", createMockIngredients(), createMockSteps()),

            // Add more mock recipes as needed
        )
    }

    private fun createMockIngredients(): List<IngredientForRecipe> {
        return listOf(
            IngredientForRecipe(1, "Beef Patty", "1 patty", "protein"),
            IngredientForRecipe(2, "Cheddar Cheese", "200 grams", "dairy"),
            IngredientForRecipe(3, "Lettuce", "400 grams","vegetable")
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