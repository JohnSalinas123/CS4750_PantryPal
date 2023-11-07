package com.example.pantry_pal.ui.grocery_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pantry_pal.databinding.FragmentGroceryListBinding

class GroceryListFragment : Fragment() {

    private var _binding: FragmentGroceryListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val groceryListViewModel =
            ViewModelProvider(this).get(GroceryListViewModel::class.java)

        _binding = FragmentGroceryListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGroceryList
        groceryListViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}