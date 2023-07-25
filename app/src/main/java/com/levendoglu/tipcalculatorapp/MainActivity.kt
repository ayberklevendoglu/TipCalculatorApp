package com.levendoglu.tipcalculatorapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.levendoglu.tipcalculatorapp.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener {
            calculateTip()
        }
    }
    @SuppressLint("SetTextI18n")
    fun calculateTip(){
        val serviceCost = binding.serviceCost.text.toString().toDouble()
        val amazing = binding.radioButtonAmazing
        val good = binding.radioButtonGood
        val okay = binding.radioButtonOkay
        val switch = binding.switch1
        if (amazing.isChecked && switch.isChecked) binding.textViewTipAmount.text = "Tip amount: $${((serviceCost * 20) / 100).roundToInt()}"
        else if (amazing.isChecked && !switch.isChecked) binding.textViewTipAmount.text = "Tip amount: $${((serviceCost * 20) / 100)}"
        else if (good.isChecked && switch.isChecked) binding.textViewTipAmount.text = "Tip amount: $${((serviceCost * 18) / 100).roundToInt()}"
        else if (good.isChecked && !switch.isChecked) binding.textViewTipAmount.text = "Tip amount: $${((serviceCost * 18) / 100)}"
        else if (okay.isChecked && switch.isChecked) binding.textViewTipAmount.text = "Tip amount: $${((serviceCost * 15) / 100).roundToInt()}"
        else if (okay.isChecked && !switch.isChecked) binding.textViewTipAmount.text = "Tip amount: $${((serviceCost * 15) / 100)}"
    }
}