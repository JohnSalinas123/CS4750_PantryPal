package com.example.pantry_pal.ui.grocery_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.databinding.ListItemCrimeBinding
import android.text.format.DateFormat
import java.util.UUID

private const val DATE_FORMAT = "EEEE, MMM, dd, yyyy"

class GroceryListHolder(
    private val binding: ListItemGroceryListBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(groceryList: GroceryList, onGroceryListClicked: (groceryId: UUID) -> Unit){
        binding.GroceryListTitle.text = GroceryList.title
        binding.GroceryListDate.text = DateFormat.format(DATE_FORMAT, GroceryList.date).toString()

        binding.root.setOnClickListener {
            onGroceryListClicked(GroceryList.id)
        }

    }
}

class GroceryListAdapter(
    private val groceryList: List<GroceryList>,
    private val onGroceryListClicked: (groceryId: UUID) -> Unit
) : RecyclerView.Adapter<GroceryListHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) : GroceryListHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGroceryListBinding.inflate(inflater, parent, false)
        return GroceryListHolder(binding)
    }

    override fun onBindViewHolder(holder: GroceryListHolder, position: Int) {
        val grocery = groceryList[position]
        holder.bind(groceryList, onGroceryListClicked)
    }

    override fun getItemCount() = GroceryList.size
}