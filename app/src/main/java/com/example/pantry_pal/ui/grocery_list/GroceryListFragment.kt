package com.example.pantry_pal.ui.grocery_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pantry_pal.R
import com.example.pantry_pal.databinding.FragmentGroceryListBinding

class GroceryListFragment : Fragment() {

    private var _binding: FragmentGroceryListBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: GroceryListViewModel
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel = ViewModelProvider(this).get(GroceryListViewModel::class.java)
        _binding = FragmentGroceryListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        adapter = object : ArrayAdapter<String>(requireContext(), R.layout.list_item_grocery, R.id.textViewItem, mutableListOf()) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                val item = getItem(position)
                val textViewItem = view.findViewById<TextView>(R.id.textViewItem)
                val buttonDeleteItem = view.findViewById<Button>(R.id.buttonDeleteItem)

                textViewItem.text = item
                buttonDeleteItem.setOnClickListener {
                    item?.let { it1 -> viewModel.removeItem(it1) }
                }

                return view
            }
        }

        binding.listViewGrocery.adapter = adapter

        viewModel.groceryItems.observe(viewLifecycleOwner) { items ->
            adapter.clear()
            adapter.addAll(items)
            adapter.notifyDataSetChanged()
        }

        binding.buttonAddItem.setOnClickListener {
            val newItem = binding.editTextItem.text.toString()
            if (newItem.isNotEmpty()) {
                viewModel.addItem(newItem)
                binding.editTextItem.text.clear()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}