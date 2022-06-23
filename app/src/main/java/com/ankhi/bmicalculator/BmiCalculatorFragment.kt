package com.ankhi.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class BmiCalculatorFragment : Fragment() {
    private lateinit var weightEt: EditText
    private lateinit var heightEt: EditText
    private lateinit var calculateBtn: Button
    private lateinit var calculateTv: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bmi_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weightEt = view.findViewById(R.id.weightEt)
        heightEt = view.findViewById(R.id.heightEt)
        calculateBtn = view.findViewById(R.id.calculateBtn)
        calculateBtn.setOnClickListener {
            var weight = weightEt.text.toString()
            var height = heightEt.text.toString()
            var w =weight.toDouble()
            var h =height.toDouble()
            var result:Double =  w / (h*h)
            val roundOff = String.format("%1f",result)
            val bundle = Bundle().apply {
                putString("result_value",roundOff)
            }
            findNavController().navigate(R.id.resultFragment,bundle)
        }
    }
}