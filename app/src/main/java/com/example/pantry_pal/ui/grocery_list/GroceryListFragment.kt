package com.example.pantry_pal.ui.grocery_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pantry_pal.R
import com.example.pantry_pal.databinding.FragmentGroceryListBinding
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.UUID

class GroceryListFragment : Fragment() {

    private var _binding: FragmentGroceryListBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

//    private lateinit var viewModel: GroceryListViewModel
//    private lateinit var groceryListViewModel: GroceryListViewModel
    private val groceryListViewModel: GroceryListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)


    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentGroceryListBinding.inflate(inflater, container, false)
//        binding.groceryRecyclerView.layoutManager = LinearLayout(context)
//
//        return binding.root
//    }


//
//    private lateinit var adapter: ArrayAdapter<String>
//    private lateinit var adapter: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        groceryListViewModel = ViewModelProvider(this).get(GroceryListViewModel::class.java)
        _binding = FragmentGroceryListBinding.inflate(inflater, container, false)
        binding.groceryRecyclerView.layoutManager = LinearLayoutManager(context)
//        val root: View = binding.root

//        adapter = object : ArrayAdapter<String>(requireContext(), R.layout.list_item_grocery, R.id.grocery_item, mutableListOf()) {
//            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//                val view = super.getView(position, convertView, parent)
//                val item = getItem(position)
//                val groceryItem = view.findViewById<TextView>(R.id.grocery_item)
//                val buttonDeleteItem = view.findViewById<Button>(R.id.buttonDeleteItem)
//
//
//                buttonDeleteItem.setOnClickListener {
//                    item?.let { it1 -> groceryListViewModel.deleteItem() }
//                }
//
//                return view
//            }
//        }


//        binding.listViewGrocery.adapter = adapter
//        binding.groceryRecyclerView  = adapter




//        binding.buttonAddItem.setOnClickListener {
//
//        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                groceryListViewModel.grocery.collect { grocery ->
                    binding.groceryRecyclerView.adapter = GroceryListAdapter(grocery)
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