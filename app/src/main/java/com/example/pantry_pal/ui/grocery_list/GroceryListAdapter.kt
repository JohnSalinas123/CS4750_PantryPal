package com.example.pantry_pal.ui.grocery_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pantry_pal.databinding.ListItemGroceryBinding
import com.example.pantry_pal.ui.grocery_list.GroceryListViewModel
import java.util.UUID

//class GroceryListAdapter(
//    private val binding:ListItemGroceryBinding
//): RecyclerView.ViewHolder(binding.root) {
////    fun bind (grocery: Grocery, onItemClick: (itemID: UUID) -> Unit) {
////        binding.groceryItem.text = grocery.item
////
////        binding.root.setOnClickListener {
////            onItemClick(grocery.id)
////        }
////
////        binding.buttonDeleteItem.setOnClickListener {
////
////        }
////    }
//
//}

//class GroceryListAdapter(
//    private val grocery: List<Grocery>,
//    private val clickListener: GroceryItemClickListener
//): RecyclerView.Adapter<GroceryListAdapter.ViewHolder>() {
//    inner class ViewHolder(val binding: ListItemGroceryBinding): RecyclerView.ViewHolder(binding.root)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val binding = ListItemGroceryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        with(holder) {
//            binding.groceryItem.text = grocery[position].item
//            binding.buttonDeleteItem.setOnClickListener {
//                clickListener.deleteGroceryItem(grocery[position])
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return grocery.size
//    }
//}

class GroceryHolder(
    private val binding: ListItemGroceryBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(grocery: Grocery) {
        binding.groceryItem.text = grocery.item

        binding.buttonDeleteItem.setOnClickListener {

        }
    }
}

class GroceryListAdapter(
    private val grocery: List<Grocery>,

): RecyclerView.Adapter<GroceryHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGroceryBinding.inflate(inflater, parent, false)
        return GroceryHolder(binding)
    }

    override fun onBindViewHolder(holder: GroceryHolder, position: Int) {
        holder.bind(grocery[position])
    }

    override fun getItemCount(): Int {
        return grocery.size
    }
}

