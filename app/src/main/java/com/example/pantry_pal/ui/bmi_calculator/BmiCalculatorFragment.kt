package com.example.pantry_pal.ui.bmi_calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pantry_pal.databinding.FragmentBmiCalculatorBinding

class BmiCalculatorFragment : Fragment() {

    private var _binding: FragmentBmiCalculatorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mealPlanViewModel =
            ViewModelProvider(this).get(BmiCalculatorViewModel::class.java)

        _binding = FragmentBmiCalculatorBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.mealPlan
//        mealPlanViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun calculateBmi() {

    }
}