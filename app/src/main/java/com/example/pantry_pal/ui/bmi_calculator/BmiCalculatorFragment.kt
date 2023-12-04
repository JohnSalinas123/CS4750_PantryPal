package com.example.pantry_pal.ui.bmi_calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pantry_pal.databinding.FragmentBmiCalculatorBinding
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

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

        binding.calculate.setOnClickListener{
            val result = calculateBmi()

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun calculateBmi(){
        val convert = 703

        val h1 = binding.height1.text.toString().toDoubleOrNull()
        val h2 = binding.height2.text.toString().toDoubleOrNull()
        val w =binding.weight.text.toString().toDoubleOrNull()

        if (h1 == null || h2 == null || w == null || h1 == 0.0 || h2 == 0.0) {
            displayBmi(0.0)
            return
        } else {
            val bmiResult: Double = if (unitSelected() == 1) {
                w/((h1+(h2*0.01)).pow(2))
            } else {
                convert * w/((h1*12+h2).pow(2))
            }
            displayBmi(bmiResult)
        }
    }

    private fun unitSelected() : Int {
        when (binding.unitOption.checkedRadioButtonId) {
            binding.metricUnit.id -> return 1
        }
        return 0
    }
    private fun displayBmi(bmi: Double) {
        binding.displayBmi.text = String.format("BMI: %.2f", bmi)
    }
}