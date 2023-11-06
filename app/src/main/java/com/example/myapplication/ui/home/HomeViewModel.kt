package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    public fun generateRandom() {
        val random = java.util.Random()
        var randomNumber = 0
        randomNumber = random.nextInt(1000)
        _text.value = randomNumber.toString()
    }

}