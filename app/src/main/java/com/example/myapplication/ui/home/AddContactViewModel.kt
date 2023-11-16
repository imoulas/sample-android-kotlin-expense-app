package com.example.myapplication.ui.home

import android.os.Environment
import android.text.Editable
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.File
import java.io.IOException

class AddContactViewModel : ViewModel() {

    private val _contactName = MutableLiveData<String>().apply {
        value = ""
    }
    val contactName: MutableLiveData<String> = _contactName
    fun setName(text: Editable) {
        _contactName.value = text.toString()
    }



    public fun SaveContact() {
        var line:String = "${contactName.value}\n"

        val path = Environment.getExternalStorageDirectory().absolutePath

        var fileName:String = "${path}${File.separator}Documents${File.separator}contact.txt"


        try {
            var fileOut = File(fileName)
            fileOut.appendText(line)

        } catch ( e: IOException) {
            Log.e("Exception","File write failed: ${e}")
        }

    }



}