package com.example.myapplication.ui.home

import android.os.Environment
import android.util.Log
import androidx.lifecycle.ViewModel
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

class ContactViewModel: ViewModel() {

    public fun ReadContacts(): String {
        val path = Environment.getExternalStorageDirectory().absolutePath
        val fileName = "${path}${File.separator}Documents${File.separator}contact.txt"
        var content = ""

        try {
            val fileIn = File(fileName)
            val reader = BufferedReader(FileReader(fileIn))
            var line: String?

            while (reader.readLine().also { line = it } != null) {
                content += "$line\n"
            }

            reader.close()
        } catch (e: IOException) {
            Log.e("Exception", "File read failed: ${e}")
        }

        return content
    }

}