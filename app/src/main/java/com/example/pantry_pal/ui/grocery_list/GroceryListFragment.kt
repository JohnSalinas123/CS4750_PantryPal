package com.example.pantry_pal.ui.grocery_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pantry_pal.databinding.FragmentGroceryListBinding

import kotlinx.coroutines.launch


class GroceryListFragment : Fragment() {

    private var _binding: FragmentGroceryListBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    private val groceryListViewModel: GroceryListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGroceryListBinding.inflate(inflater, container, false)
        binding.groceryRecyclerView.layoutManager = LinearLayoutManager(context)
    return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                groceryListViewModel.grocery.collect { grocery ->
                    binding.groceryRecyclerView.adapter = GroceryListAdapter(grocery, groceryListViewModel)
                }
            }
        }
        binding.apply {
            buttonAddItem.setOnClickListener {
                val newItem = editTextItem.text.toString()
                if (newItem.isNotEmpty()) {
                    groceryListViewModel.addItem(newItem)

                    editTextItem.text.clear()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}