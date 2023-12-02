package com.example.pantry_pal.ui.recipes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pantry_pal.data.Recipe
import com.example.pantry_pal.databinding.FragmentRecipesBinding

class RecipesFragment : Fragment() {

    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!

    private lateinit var recipesViewModel: RecipesViewModel
    private lateinit var recipesAdapter: RecipesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("RecipesFragment", "onCreateView")
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // ViewModel
        recipesViewModel =
            ViewModelProvider(this)[RecipesViewModel::class.java]

        // RecyclerView
        recipesAdapter = RecipesAdapter { recipe -> onRecipeClick(recipe)}
        binding.recipeRecyclerView.adapter = recipesAdapter
        binding.recipeRecyclerView.layoutManager = LinearLayoutManager(context)

        // Live Data
        recipesViewModel.recipes.observe(viewLifecycleOwner) { recipes ->
            Log.d("RecipesFragment", "Recipes updated: $recipes")
            recipesAdapter.submitList(recipes)
        };

        recipesViewModel.getRecipes()



        return root
    }

    private fun onRecipeClick(recipe: Recipe) {
        Toast.makeText(requireContext(), "Clicked on recipe: ${recipe.name}", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}