package com.example.pantry_pal.ui.recipes

import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pantry_pal.R
import com.example.pantry_pal.data.Recipe
import com.example.pantry_pal.databinding.ListItemRecipeBinding


class RecipeViewHolder(
    private val binding: ListItemRecipeBinding,
    private val onItemClick: (Recipe) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(recipe: Recipe) {
        binding.recipeName.text = recipe.name
        binding.recipeCalories.text = binding.root.context.getString(R.string.calories_format, recipe.calories)
        binding.recipeDiet.text = recipe.diet
        binding.recipeDescription.text = recipe.description

        itemView.setOnClickListener { onItemClick(recipe)}

    }

}
class RecipesAdapter(private val onItemClick: (Recipe) -> Unit) :

    ListAdapter<Recipe, RecipeViewHolder>(RecipeDiffCallback()) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ListItemRecipeBinding.inflate(inflater, parent, false)
            return RecipeViewHolder(binding, onItemClick)
        }

        override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
            val recipe = getItem(position)
            holder.bind(recipe)
        }





}

class RecipeDiffCallback: DiffUtil.ItemCallback<Recipe>() {

    override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem == newItem
    }

}