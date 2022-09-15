package com.example.fintech1832_mvpm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _result = MutableLiveData<Float>()
    val result: LiveData<Float> get() = _result

    fun addition( firstNumber: Float, secondNumber: Float ) {
        val result = firstNumber + secondNumber
        _result.value = result
    }
    fun subtraction( firstNumber: Float, secondNumber: Float ) {
        val result = firstNumber - secondNumber
        _result.value = result
    }
    fun multiplication( firstNumber: Float, secondNumber: Float ) {
        val result = firstNumber * secondNumber
        _result.value = result
    }
    fun division( firstNumber: Float, secondNumber: Float ) {
        val result = firstNumber / secondNumber
        _result.value = result
    }

}