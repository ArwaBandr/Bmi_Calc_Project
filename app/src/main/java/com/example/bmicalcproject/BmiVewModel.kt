package com.example.bmicalcproject

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiVewModel:ViewModel() {
    var  resultText by mutableStateOf("")

    fun claclateBmi(Height: Float, Weight: Float){
        var heightInMeter =Height / 100
        var result = Weight / (heightInMeter * heightInMeter)
        resultText = when {
            result < 18.5 -> "Underweight"
            result in 18.5..24.9 -> "Normal Weight"
            result in 25.0..29.9 -> "Overweight"
            result in 30.0..34.9 -> "Obesity Class I"
            result in 35.0..39.9 -> "Obesity Class II"
            else -> "Obesity Class III"
        }

    }
}