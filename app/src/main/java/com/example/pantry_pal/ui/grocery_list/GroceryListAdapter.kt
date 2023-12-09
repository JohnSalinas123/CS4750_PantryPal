package com.example.pantry_pal.ui.grocery_list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pantry_pal.databinding.ListItemGroceryBinding


class GroceryHolder(
    private val binding: ListItemGroceryBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(grocery: Grocery, viewModel: GroceryListViewModel) {
        binding.groceryItem.text = grocery.item

        binding.buttonDeleteItem.setOnClickListener {
            viewModel.deleteItem(grocery.item)
            Log.d("Clicked", "Clicked Button" + grocery.item)
        }
    }
}

class GroceryListAdapter(
    private val grocery: List<Grocery>,
    private val viewModel: GroceryListViewModel
): RecyclerView.Adapter<GroceryHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGroceryBinding.inflate(inflater, parent, false)
        return GroceryHolder(binding)
    }

    override fun onBindViewHolder(holder: GroceryHolder, position: Int) {
        holder.bind(grocery[position], viewModel)
    }

    override fun getItemCount(): Int {
        return grocery.size
    }
}

