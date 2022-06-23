package com.ankhi.bmicalculator

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class ResultFragment : Fragment() {
    lateinit var resultTv: TextView
    lateinit var image: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        val result = bundle?.getString("result_value")

        resultTv = view.findViewById(R.id.scoreShowTv)
        image = view.findViewById(R.id.imageId)
        if (result?.toDouble()!! > 18.5 && result.toDouble() <= 24.9) {
            resultTv.text = "Your BMI score is $result\n you are normal weight"
            image.setImageResource(R.drawable.normal)
        } else if (result?.toDouble()!! < 18.5) {
            resultTv.text = "Your BMI score is $result\n you are under weight"
            image.setImageResource(R.drawable.under)
        }
        if (result?.toDouble()!! > 24.9) {
            resultTv.text = "Your BMI score is $result\n you are Over Weight"
            image.setImageResource(R.drawable.over)
        }


    }


}